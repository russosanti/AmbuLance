package Utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
 
/**
 * Escanea todas las subclases de una clase
 */
public class SubClassFinder {
	private Class<?> classToSearch = null;
	private Map<URL, String> classpathLocations = new HashMap<URL, String>();
	private Map<Class<?>, URL> results = new HashMap<Class<?>, URL>();
	private List<Throwable> errors = new ArrayList<Throwable>();
 
	public SubClassFinder() {
		refreshLocations();
	}
 
	public final void refreshLocations() {
		synchronized (classpathLocations) {
			classpathLocations = getClasspathLocations();
		}
	}
 
	/**
	 * @param fqcn Nombre de la superclase/interfaz donde
	 */
	public final Vector<Class<?>> findSubclasses(String fqcn) {
		synchronized (classpathLocations) {
			synchronized (results) {
				try {
					classToSearch = null;
					errors = new ArrayList<Throwable>();
					results = new TreeMap<Class<?>, URL>(CLASS_COMPARATOR);
					if (fqcn.startsWith(".") || fqcn.endsWith(".")) {
						return new Vector<Class<?>>();
					}
 
					// Determine search class from fqcn
					try {
						classToSearch = Class.forName(fqcn);
					} catch (ClassNotFoundException ex) {
						errors.add(ex);
						return new Vector<Class<?>>();
					}
					return findSubclasses(classToSearch, classpathLocations);
				} finally {  //me obliga al finally
				}
			}
		}
	}
 
	public final List<Throwable> getErrors() {
		return new ArrayList<Throwable>(errors);
	}
 
	/** Guarda la localizacion de la clase pasada por parametro
	*/
	public final URL getLocationOf(Class<?> cls) {
		if (results != null){
			return results.get(cls);
		}else{
			return null;
		}
	}
 
	/** Determina toda la localizacion del classpath
	 */
	public final Map<URL, String> getClasspathLocations() {
		Map<URL, String> map = new TreeMap<URL, String>(URL_COMPARATOR);
		File file = null;
		String pathSep = System.getProperty("path.separator");
		String classpath = System.getProperty("java.class.path");
		StringTokenizer st = new StringTokenizer(classpath, pathSep);
		while (st.hasMoreTokens()) {
			String path = st.nextToken();
			file = new File(path);
			include(null, file, map);
		}
		return map;
	}
 
	private final static FileFilter DIRECTORIES_ONLY = new FileFilter() {
		public boolean accept(File f) {
			if (f.exists() && f.isDirectory())
				return true;
			else
				return false;
		}
	};
 
	private final static Comparator<URL> URL_COMPARATOR = new Comparator<URL>() {
		public int compare(URL u1, URL u2) {
			return String.valueOf(u1).compareTo(String.valueOf(u2));
		}
	};
 
	private final static Comparator<Class<?>> CLASS_COMPARATOR = new Comparator<Class<?>>() {
		public int compare(Class<?> c1, Class<?> c2) {
			return String.valueOf(c1).compareTo(String.valueOf(c2));
		}
	};
 
	private final void include(String name, File file, Map<URL, String> map) {
		if (!file.exists())
			return;
		if (!file.isDirectory()) {
			includeJar(file, map);
			return;
		}
		if (name == null)
			name = "";
		else
			name += ".";
		// agrego subpaquetes
		File[] dirs = file.listFiles(DIRECTORIES_ONLY);
		for (int i = 0; i < dirs.length; i++) {
			try {
				// agrego al paquete actual
				map.put(new URL("file://" + dirs[i].getCanonicalPath()), name
						+ dirs[i].getName());
			} catch (IOException ioe) {
				return;
			}
 
			include(name + dirs[i].getName(), dirs[i], map);
		}
	}
 
	private void includeJar(File file, Map<URL, String> map) {
		if (file.isDirectory())
			return;
		URL jarURL = null;
		JarFile jar = null;
		try {
			jarURL = new URL("file:/" + file.getCanonicalPath());
			jarURL = new URL("jar:" + jarURL.toExternalForm() + "!/");
			JarURLConnection conn = (JarURLConnection) jarURL.openConnection();
			jar = conn.getJarFile();
		} catch (Exception e) {
			// error de que no es un JAR o un archivo
			return;
		}
		if (jar == null || jarURL == null)
			return;
		// incluyo el paquete por default
		map.put(jarURL, "");
		Enumeration<JarEntry> e = jar.entries();
		while (e.hasMoreElements()) {
			JarEntry entry = e.nextElement();
			if (entry.isDirectory()) {
				if (entry.getName().toUpperCase().equals("META-INF/"))
					continue;
				try {
					map.put(new URL(jarURL.toExternalForm() + entry.getName()),
							packageNameFor(entry));
				} catch (MalformedURLException murl) {
					continue;
				}
			}
		}
	}
 
	private static String packageNameFor(JarEntry entry) {
		if (entry == null)
			return "";
		String s = entry.getName();
		if (s == null)
			return "";
		if (s.length() == 0)
			return s;
		if (s.startsWith("/"))
			s = s.substring(1, s.length());
		if (s.endsWith("/"))
			s = s.substring(0, s.length() - 1);
		return s.replace('/', '.');
	}
 
	private final Vector<Class<?>> findSubclasses(Class<?> superClass,Map<URL, String> locations) {
		Vector<Class<?>> v = new Vector<Class<?>>();
		Vector<Class<?>> w = null;
		Iterator<URL> it = locations.keySet().iterator();
		while (it.hasNext()) {
			URL url = it.next();
			w = findSubclasses(url, locations.get(url), superClass);
			if (w != null && (w.size() > 0))
				v.addAll(w);
		}
 
		return v;
	}
 
	private final Vector<Class<?>> findSubclasses(URL location,String packageName, Class<?> superClass) {
		synchronized (results) {
			Map<Class<?>, URL> thisResult = new TreeMap<Class<?>, URL>(CLASS_COMPARATOR);
			Vector<Class<?>> v = new Vector<Class<?>>();
			// TODO: double-check for null search class
			String fqcn = classToSearch.getName();
			List<URL> knownLocations = new ArrayList<URL>();
			knownLocations.add(location);
			// TODO: add getResourceLocations() to this list
			// iterate matching package locations...
			for (int loc = 0; loc < knownLocations.size(); loc++) {
				URL url = knownLocations.get(loc);
				// Get a File object for the package
				File directory = new File(url.getFile());
				if (directory.exists()) {
					String[] files = directory.list();
					for (int i = 0; i < files.length; i++) {
						if (files[i].endsWith(".class")) {
							String classname = files[i].substring(0, files[i].length() - 6);
							try {
								Class<?> c = Class.forName(packageName + "." + classname);
								if (superClass.isAssignableFrom(c) && !fqcn.equals(packageName + "." + classname)) {
									thisResult.put(c, url);
								}
							} catch (ClassNotFoundException cnfex) {
								errors.add(cnfex);
							} catch (Exception ex) {
								errors.add(ex);
							}
						}
					}
				} else {
					try {
						JarURLConnection conn = (JarURLConnection) url.openConnection();
						JarFile jarFile = conn.getJarFile();
						Enumeration<JarEntry> e = jarFile.entries();
						while (e.hasMoreElements()) {
							JarEntry entry = e.nextElement();
							String entryname = entry.getName();
							if (!entry.isDirectory() && entryname.endsWith(".class")) {
								String classname = entryname.substring(0,entryname.length() - 6);
								if (classname.startsWith("/"))
									classname = classname.substring(1);
								classname = classname.replace('/', '.');
								try {
									// TODO: verify this block
									Class<?> c = Class.forName(classname);
									if (superClass.isAssignableFrom(c) && !fqcn.equals(classname)) {
										thisResult.put(c, url);
									}
								} catch (ClassNotFoundException cnfex) {
									errors.add(cnfex);
								} catch (NoClassDefFoundError ncdfe) {
									errors.add(ncdfe);
								} catch (UnsatisfiedLinkError ule) {
									errors.add(ule);
								} catch (Exception exception) {
									errors.add(exception);
								} catch (Error error) {
									errors.add(error);
								}
							}
						}
					} catch (IOException ioex) {
						errors.add(ioex);
					}
				}
			}
			results.putAll(thisResult);
			Iterator<Class<?>> it = thisResult.keySet().iterator();
			while (it.hasNext()) {
				v.add(it.next());
			}
			return v;
		}
	}
 
	public static void ejemplo(String s) {
		s = "Sistema.Tipos.Ambulancias.Ambulancia";
 
		SubClassFinder finder = null;
		Vector<Class<?>> v = null;
		@SuppressWarnings("unused")
		List<Throwable> errors = null;
 
		finder = new SubClassFinder();
		v = finder.findSubclasses(s);
		errors = finder.getErrors();
 
		System.out.println("RESULTS:");
		if (v != null && v.size() > 0) {
			for (Class<?> cls : v) {
				System.out.println(cls + " in " + ((finder != null) ? String.valueOf(finder.getLocationOf(cls)) : "?"));
			}
		} else {
			System.out.println("No subclasses of " + s + " found.");
		}
	}
}