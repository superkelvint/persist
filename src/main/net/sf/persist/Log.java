// $Id$

package net.sf.persist;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wraps log4j using reflection to avoid runtime dependencies.
 */
public final class Log {

	// avoid instantiation
	private Log() {
		// do nothing
	}

	public static final String ENGINE = "persist.engine";
	public static final String PROFILING = "persist.profiling";
	public static final String RESULTS = "persist.results";
	public static final String PARAMETERS = "persist.parameters";

	private static boolean loggingEnabled = false;
	static {
		try {
			Class.forName("org.apache.log4j.Logger");
			loggingEnabled = true;
		} catch (ClassNotFoundException e) {
			loggingEnabled = false;
		}
	}

	public static void trace(final String name, final Object message) {
		if (loggingEnabled) {
			Logger.getLogger(name).finest(message.toString());
		}
	}

	public static boolean isTraceEnabled(final String name) {
		return loggingEnabled && Logger.getLogger(name).isLoggable(Level.FINEST);
	}

	public static void debug(final String name, final Object message) {
		if (loggingEnabled) {
			Logger.getLogger(name).finer(message.toString());
		}
	}

	public static boolean isDebugEnabled(final String name) {
		return loggingEnabled && Logger.getLogger(name).isLoggable(Level.FINER);
	}

	public static void info(final String name, final Object message) {
		if (loggingEnabled) {
			Logger.getLogger(name).info(message.toString());
		}
	}

	public static boolean isInfoEnabled(final String name) {
		return loggingEnabled && Logger.getLogger(name).isLoggable(Level.INFO);
	}

	public static void error(final String name, final Object message) {
		if (loggingEnabled) {
			Logger.getLogger(name).severe(message.toString());
		}
	}

	/**
	 * Converts types expected in prepared statement parameters to a suitable
	 * string to be added to log output.
	 */
	public static String objectToString(final Object obj) {

		String str = null;

		if (obj instanceof String) {
			str = (String) obj;
		} else if (obj instanceof byte[]) {
			str = java.util.Arrays.toString((byte[]) obj);
			str = str.substring(1, str.length() - 1);
		} else if (obj instanceof Byte[]) {
			str = java.util.Arrays.toString((Byte[]) obj);
			str = str.substring(1, str.length() - 1);
		} else if (obj instanceof char[]) {
			str = java.util.Arrays.toString((char[]) obj);
			str = str.substring(1, str.length() - 1);
		} else if (obj instanceof Character[]) {
			str = java.util.Arrays.toString((Character[]) obj);
			str = str.substring(1, str.length() - 1);
		} else {
			str = obj == null ? "null" : obj.toString();
		}

		return (str.length() > 64) ? str.substring(0, 64) + "..." : str;
	}

	public static String sqlTypeToString(final int type) {

		final String ret;

		if (type == java.sql.Types.ARRAY) {
			ret = "ARRAY";
		} else if (type == java.sql.Types.BIGINT) {
			ret = "BIGINT";
		} else if (type == java.sql.Types.BINARY) {
			ret = "BINARY";
		} else if (type == java.sql.Types.BIT) {
			ret = "BIT";
		} else if (type == java.sql.Types.BLOB) {
			ret = "BLOB";
		} else if (type == java.sql.Types.BOOLEAN) {
			ret = "BOOLEAN";
		} else if (type == java.sql.Types.CHAR) {
			ret = "CHAR";
		} else if (type == java.sql.Types.CLOB) {
			ret = "CLOB";
		} else if (type == java.sql.Types.DATALINK) {
			ret = "DATALINK";
		} else if (type == java.sql.Types.DATE) {
			ret = "DATE";
		} else if (type == java.sql.Types.DECIMAL) {
			ret = "DECIMAL";
		} else if (type == java.sql.Types.DISTINCT) {
			ret = "DISTINCT";
		} else if (type == java.sql.Types.DOUBLE) {
			ret = "DOUBLE";
		} else if (type == java.sql.Types.FLOAT) {
			ret = "FLOAT";
		} else if (type == java.sql.Types.INTEGER) {
			ret = "INTEGER";
		} else if (type == java.sql.Types.JAVA_OBJECT) {
			ret = "JAVA_OBJECT";
		} else if (type == java.sql.Types.LONGVARBINARY) {
			ret = "LONGVARBINARY";
		} else if (type == java.sql.Types.LONGVARCHAR) {
			ret = "LONGVARCHAR";
		} else if (type == java.sql.Types.NULL) {
			ret = "NULL";
		} else if (type == java.sql.Types.NUMERIC) {
			ret = "NUMERIC";
		} else if (type == java.sql.Types.OTHER) {
			ret = "OTHER";
		} else if (type == java.sql.Types.REAL) {
			ret = "REAL";
		} else if (type == java.sql.Types.REF) {
			ret = "REF";
		} else if (type == java.sql.Types.SMALLINT) {
			ret = "SMALLINT";
		} else if (type == java.sql.Types.STRUCT) {
			ret = "STRUCT";
		} else if (type == java.sql.Types.TIME) {
			ret = "TIME";
		} else if (type == java.sql.Types.TIMESTAMP) {
			ret = "TIMESTAMP";
		} else if (type == java.sql.Types.TINYINT) {
			ret = "TINYINT";
		} else if (type == java.sql.Types.VARBINARY) {
			ret = "VARBINARY";
		} else if (type == java.sql.Types.VARCHAR) {
			ret = "VARCHAR";
		} else {
			ret = "" + type;
		}

		return ret;

	}

}
