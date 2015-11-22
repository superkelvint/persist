// $Id$

package net.sf.persist;

import java.util.List;

/**
 * Represents a result from an insert operation with auto-generated keys.
 */
public final class Result {

	public int rowsModified;
	public List<String> generatedKeys;
    public int generatedKey = -1;

	public Result(final int rowsModified, final List<String> generatedKeys) {
		this.rowsModified = rowsModified;
		this.generatedKeys = generatedKeys;
	}

    public Result(int rowsModified, int generatedKey) {
        this.rowsModified = rowsModified;
        this.generatedKey = generatedKey;
    }

    public int getRowsModified() {
		return rowsModified;
	}

	public List<String> getGeneratedKeys() {
		return generatedKeys;
	}

}
