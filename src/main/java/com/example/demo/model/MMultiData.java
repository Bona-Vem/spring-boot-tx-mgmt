package com.example.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MMultiData extends ArrayList<LinkedHashMap<String, Object>> implements MDataProtocol {
	private static final long	serialVersionUID	= 8154940219462381299L;
	private boolean				nullToInitialize	= false;
	
	public boolean isNullToInitialize() {
		return this.nullToInitialize;
	}
	
	public void setNullToInitialize(boolean nullToInitialize) {
		this.nullToInitialize = nullToInitialize;
	}
	
	/**
	 * Constructor for MMultiData
	 */
	public MMultiData() {}
	
	/**
	 * Constructor for MMultiData
	 *
	 * @param map
	 */
	public MMultiData(List map) {
		super(map);
	}
	
	public Object[] getKeys() {
		Object[] keyArr = {};
		
		if (size() > 0) {
			keyArr = get(0).keySet().toArray();
		}
		
		return keyArr;
	}
	
	public void put(Object key, List l) {
		
		for (int i = 0; i < l.size(); i++ ) {
			
			if (size() < i + 1) {
				addMData(new MData());
			}
			
			((Map)get(i)).put(key, l.get(i));
		}
		
	}
	
	public void putAll(List m) {
		clear();
		addAll(m);
	}
	
	/**
	 * Delete the data (column) for a given key.
	 * 
	 * @param key Key in column to delete
	 *
	 * @see       #removeColumn(String)
	 */
	public void removeColumn(String key) {
		
		for (int i = 0; i < this.size(); i++ ) {
			
			if (this.get(i).containsKey(key)) {
				this.get(i).remove(key);
			}
			
		}
		
	}
	
	/**
	 * Delete the data (row) for a given key.
	 * 
	 * @param key Key in row to delete
	 *
	 * @see       #removeRow(int)
	 */
	public void removeRow(int keyIndex) {
		remove(keyIndex);
	}
	
	public Object getKeyWithIndex(int keyIndex) {
		return getKeyWithIndex(keyIndex, 0);
	}
	
	/**
	 * Returns the key object corresponding to the index.
	 * 
	 * @param  keyIndex
	 *
	 * @return          int
	 */
	public Object getKeyWithIndex(int keyIndex, int index) {
		Object		retObj	= null;
		Set<String>	tempSet	= this.get(index).keySet();
		
		if (keyIndex >= tempSet.size()) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_001.getCode(),
			 * this.getClass(), "getKeyWithIndex(int keyIndex, int index)");
			 */
		}
		
		Iterator<String> iterator = tempSet.iterator();
		
		for (int inx = 0; inx <= keyIndex; inx++ ) {
			retObj = iterator.next();
		}
		
		return retObj;
	}
	
	// ClassCastException 오류나서 MData 제거함 // 2018-08-28 jessy
	public List<MData> get(Object key) {
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < size(); i++ ) {
			list.add(get(i).get(key));
		}
		
		return list;
	}
	
	public List<MData> toListMData() {
		List<MData> listMData = new ArrayList<>();
		
		for (LinkedHashMap<String, Object> map : this) {
			listMData.add(new MData(map));
		}
		
		return listMData;
	}
	
	public void addMData(MData mData) {
		addMData(new MData(mData));
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue Object
	 */
	public void modify(String key, int index, Object replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modify(String key, int index, Object replaceValue)");
			 */
		}
		
		if (!get(index).containsKey(key)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
			 * this.getClass(), "modify(String key, int index, Object replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue boolean
	 */
	public void modifyBoolean(String key, int index, boolean replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modifyBoolean(String key, int index, boolean replaceValue)");
			 */
		}
		
		if (!get(index).containsKey(key)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
			 * this.getClass(), "modifyBoolean(String key, int index, boolean replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue String
	 */
	public void modifyString(String key, int index, String replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modifyString(String key, int index, String replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue int
	 */
	public void modifyInt(String key, int index, int replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modify(Object key, int index, Object replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue double
	 */
	public void modifyDouble(String key, int index, double replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modifyDouble(String key, int index, double replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue float
	 */
	public void modifyFloat(String key, int index, float replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modifyFloat(String key, int index, float replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue long
	 */
	public void modifyLong(String key, int index, long replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modify(Object key, int index, Object replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue short
	 */
	public void modifyShort(String key, int index, short replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modifyShort(String key, int index, short replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Replace the value at the index end corresponding to the corresponding key value with the value passed to the parameter.
	 * 
	 * @param key          String
	 * @param index        int
	 * @param replaceValue BigDecimal
	 */
	public void modifyBigDecimal(String key, int index, BigDecimal replaceValue) {
		
		if (!(size() > index)) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_002.getCode(),
			 * this.getClass(), "modifyBigDecimal(String key, int index, BigDecimal replaceValue)");
			 */
		}
		
		get(index).put(key, replaceValue);
	}
	
	/**
	 * Set the value of the object type in the corresponding key value.
	 * 
	 * @param key   Object
	 * @param value Object
	 */
	public void add(String key, Object value) {
		boolean add = false;
		
		for (int i = 0; i < size(); i++ ) {
			
			if (!get(i).containsKey(key)) {
				get(i).put(key, value);
				add = true;
				break;
			}
			
		}
		
		if (!add) {
			MData row = new MData();
			//row.set( key, value );
			addMData(row);
		}
		
	}
	
	private Object getObject(Object key, int index) {
		
		try {
			
			if (size() <= index) {
				return null;
			} else {
				return get(index).get(key);
			}
			
		} catch (IndexOutOfBoundsException ioe) {
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
			 * this.getClass(), "getObject(Object key, int index)", ioe);
			 */
		}
		
		return null;
	}
	
	/**
	 * Return the value corresponding to the key and index in the form of an object.
	 * Returns a null or empty string (if value is null and isNullToInitialise() is true)
	 * if the key or value does not exist.
	 * 
	 * @param  key   Object
	 * @param  index int
	 *
	 * @return       Object
	 */
	public Object get(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null && isNullToInitialize()) {
			return "";
		}
		
		return o;
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index to the object.
	 * Return a null or empty string (if value is null and isNullToInitialise () is true)
	 * if the key or value does not exist.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          Object
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #get(Object, int)
	 */
	public Object get(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return get(key, index);
	}
	
	/**
	 * Return the value corresponding to the key and index in String format.
	 * Returns a null or empty string (if value is null and isNullToInitialise() is true)
	 * if the key or value does not exist.
	 * 
	 * @param  key   String
	 * @param  index int
	 *
	 * @return       String
	 */
	public String getString(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null) {
			
			if (isNullToInitialize()) {
				return "";
			}
			
			return null;
		} else // If the key type is BigDecimal, it is represented as 0E-8 when the decimal point is set at least 8 digits.
		if (o instanceof BigDecimal) {
			return ((BigDecimal)o).toPlainString();
		} else {
			return o.toString();
		}
		
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index in String format.
	 * Returns a null or empty string (if value is null and isNullToInitialise() is true)
	 * if the key or value does not exist.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          String
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #getString(Object, int)
	 */
	public String getString(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return getString(key, index);
	}
	
	/**
	 * Return the value corresponding to the key and index in boolean form.
	 * Returns LRuntimeException or 0 (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting will occur only if value is Boolean or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  key   Object
	 * @param  index int
	 *
	 * @return       boolean
	 */
	public boolean getBoolean(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null) {
			
			if (isNullToInitialize()) {
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
			 * this.getClass(), "getBoolean(Object key, int index)");
			 */
		} else {
			
			if (o instanceof Boolean) {
				return ((Boolean)o);
			}
			
			if (o instanceof String) {
				
				try {
					return Boolean.parseBoolean(o.toString());
				} catch (Exception e) {
					/*
					 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
					 * this.getClass(), "getBoolean(Object key, int index)", e);
					 */
				}
				
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
			 * this.getClass(), "getBoolean(Object key, int index)");
			 */
		}
		
		return false; // prevent compile error line. unreachable block.
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index in boolean form.
	 * Returns LRuntimeException or 0 (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting occurs only if value is Boolean or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          boolean
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #getBoolean(Object, int)
	 */
	public boolean getBoolean(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return getBoolean(key, index);
	}
	
	/**
	 * Return the value corresponding to the key and index in int.
	 * Returns MRuntimeException or 0 (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting will occur only if value is Number or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  key   Object
	 * @param  index int
	 *
	 * @return       int
	 */
	public int getInt(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null) {
			
			if (isNullToInitialize()) {
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
			 * this.getClass(), "getInt(Object key, int index)");
			 */
		} else {
			
			if (o instanceof Number) {
				return ((Number)o).intValue();
			}
			
			if (o instanceof String) {
				
				try {
					return Integer.parseInt(o.toString());
				} catch (Exception e) {
					/*
					 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
					 * this.getClass(), "getInt(Object key, int index)", e);
					 */
				}
				
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
			 * this.getClass(), "getInt(Object key, int index)");
			 */
		}
		
		return 0; // prevent compile error line. It's unreachable block.
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index in int form.
	 * Returns LRuntimeException or 0 (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting will occur only if value is Number or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          int
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #getInt(Object, int)
	 */
	public int getInt(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return getInt(key, index);
	}
	
	/**
	 * Return the value corresponding to the key and index in double.
	 * Returns MRuntimeException or 0.0D (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting occurs only if value is Number or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  key   Object
	 * @param  index int
	 *
	 * @return       double
	 */
	public double getDouble(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null) {
			
			if (isNullToInitialize()) {
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
			 * this.getClass(), "getDouble(Object key, int index)");
			 */
		} else {
			
			if (o instanceof Number) {
				return ((Number)o).doubleValue();
			}
			
			if (o instanceof String) {
				
				try {
					return Double.parseDouble(o.toString());
				} catch (Exception e) {
					/*
					 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
					 * this.getClass(), "getDouble(Object key, int index)", e);
					 */
				}
				
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
			 * this.getClass(), "getDouble(Object key, int index)");
			 */
		}
		
		return 0.0D; // prevent compile error line. unreachable block.
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index in double.
	 * Returns MRuntimeException or 0.0D (value is null and isNullToInitialise() is true.)
	 * if the key or value does not exist <br>
	 * If value exists, type-casting will occur only if value is Number or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          double
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #getDouble(Object, int)
	 */
	public double getDouble(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return getDouble(key, index);
	}
	
	/**
	 * Return the value corresponding to the key and index in float form.
	 * Returns MRuntimeException or 0.0F (if value is null and isNullToInitialize() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting occurs only if value is Number or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  key   Object
	 * @param  index int
	 *
	 * @return       float
	 */
	public float getFloat(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null) {
			
			if (isNullToInitialize()) {
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
			 * this.getClass(), "getFloat(Object key, int index)");
			 */
		} else {
			
			if (o instanceof Number) {
				return ((Number)o).floatValue();
			}
			
			if (o instanceof String) {
				
				try {
					return Float.parseFloat(o.toString());
				} catch (Exception e) {
					/*
					 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
					 * this.getClass(), "getFloat(Object key, int index)", e);
					 */
				}
				
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
			 * this.getClass(), "getFloat(Object key, int index)");
			 */
		}
		
		return 0.0F; // prevent compile error  line. unreachable block.
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index in float.
	 * Return MRuntimeException or 0.0F (if value is null and isNullToInitialise() is true).
	 * if no key or value exists<br>
	 * If value exists, type-casting occurs only if value is Number or String,
	 * otherwise LRuntimeException will occur.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          float
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #getFloat(Object, int)
	 */
	public float getFloat(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return getFloat(key, index);
	}
	
	/**
	 * Return the value corresponding to the key and index in long format.
	 * Returns MRuntimeException or 0L (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting occurs only if value is Number or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  key   Object
	 * @param  index int
	 *
	 * @return       long
	 */
	public long getLong(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null) {
			
			if (isNullToInitialize()) {
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
			 * this.getClass(), "getLong(Object key, int index)");
			 */
		} else {
			
			if (o instanceof Number) {
				return ((Number)o).longValue();
			}
			
			if (o instanceof String) {
				
				try {
					return Long.parseLong(o.toString());
				} catch (Exception e) {
					/*
					 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
					 * this.getClass(), "getLong(Object key, int index)", e);
					 */
				}
				
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
			 * this.getClass(), "getLong(Object key, int index)");
			 */
		}
		
		return 0L; // prevent compile error line. unreachable block.
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index in long format.
	 * Returns MRuntimeException or 0L (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting occurs only if value is Number or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          long
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #getLong(Object, int)
	 */
	public long getLong(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return getLong(key, index);
	}
	
	/**
	 * Return the value corresponding to the key and index in a short form.
	 * Returns MRuntimeException or 0 (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting will occur only briefly
	 * if value is Number or String, otherwise MRuntimeException will occur.
	 * 
	 * @param  key   Object
	 * @param  index int
	 *
	 * @return       short
	 */
	public short getShort(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null) {
			
			if (isNullToInitialize()) {
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_005.getCode(),
			 * this.getClass(), "getShort(Object key, int index)");
			 */
		} else {
			
			if (o instanceof Number) {
				return ((Number)o).shortValue();
			}
			
			if (o instanceof String) {
				
				try {
					return Short.parseShort(o.toString());
				} catch (Exception e) {
					/*
					 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
					 * this.getClass(), "getShort(Object key, int index)", e);
					 */
				}
				
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
			 * this.getClass(), "getShort(Object key, int index)");
			 */
		}
		
		return 0; // prevent compile error line. unreachable block.
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index in a short format.
	 * Returns MRuntimeException or 0 (if value is null and isNullToInitialise() is true)
	 * if key or value does not exist.<br>
	 * If value exists, type-casting will occur only if value is Number or String,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          short
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #getShort(Object, int)
	 */
	public short getShort(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return getShort(key, index);
	}
	
	/**
	 * Return the value corresponding to the key and index in the BegDecimal format.
	 * If the key or value does not exist, then MRuntimeException or BigDecimal (0)
	 * (if value is null and isNullToInitialize() is true).< br >
	 * If value is present, type-casting will occur only if value is BigDecimal,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  key   Object
	 * @param  index int
	 *
	 * @return       BigDecimal
	 */
	public BigDecimal getBigDecimal(Object key, int index) {
		Object o = getObject(key, index);
		
		if (o == null) {
			
			if (isNullToInitialize()) {
				return new BigDecimal(0);
			}
			
			return null;
		} else {
			
			if (o instanceof BigDecimal) {
				return (BigDecimal)o;
			}
			
			// NOTE
			if (o instanceof Number) {
				return new BigDecimal(((Number)o).doubleValue());
			}
			
			if (o instanceof String) {
				
				try {
					return new BigDecimal((String)o);
				} catch (Exception e) {
					/*
					 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_003.getCode(),
					 * this.getClass(), "getBigDecimal(Object key, int index)", e);
					 */
				}
				
			}
			
			/*
			 * MExceptionPitcher.throwMRuntimeException(MRExceptionCode.COM_COL_004.getCode(),
			 * this.getClass(), "getBigDecimal(Object key, int index)");
			 */
		}
		
		return new BigDecimal(0); // prevent compile error line. unreachable block.
	}
	
	/**
	 * Return the value corresponding to the keyIndex and index in BegDecimal format.
	 * If the key or value does not exist, then MRuntimeException or BigDecimal(0)
	 * (if value is null and isNullToInitialize () is true).< br >
	 * If value is present, type-casting will occur only if value is BigDecimal,
	 * otherwise MRuntimeException will occur.
	 * 
	 * @param  keyIndex int
	 * @param  index    int
	 *
	 * @return          BigDecimal
	 *
	 * @see             #getKeyWithIndex(int)
	 * @see             #getBigDecimal(Object, int)
	 */
	public BigDecimal getBigDecimal(int keyIndex, int index) {
		Object key = getKeyWithIndex(keyIndex, index);
		return getBigDecimal(key, index);
	}
	
	public int getDataCount() {
		return this.size();
	}
	
	@SuppressWarnings({"unchecked"})
	public MData getMData(int key) {
		Object obj = get(key);
		
		if (obj instanceof MData) {
			return (MData)obj;
		} else if (obj instanceof LinkedHashMap) {
			return new MData((LinkedHashMap<String, Object>)obj);
		} else {
			return obj == null ? new MData() : (MData)obj;
		}
		
	}
	
	public void addMMultiData(MMultiData mData) {
		int cnt = mData.size();
		
		for (int i = 0; i < cnt; i++ ) {
			this.addMData(new MData(mData.get(i)));
		}
		
	}
	
	public void addMMultiDataNoClone(MMultiData mData) {
		int cnt = mData.size();
		
		for (int i = 0; i < cnt; i++ ) {
			this.add(mData.get(i));
		}
		
	}
	
	public void addMDataNoClone(MData data) {
		addMData(data);
	}
	
	/**
	 * This method returns the number of keys that make up the MMultiData.
	 * 
	 * @return int
	 */
	public int getKeyCount() {
		int keyCount = 0;
		if (size() > 0)
			keyCount = get(0).size();
		return keyCount;
	}
	
	/**
	 * Returns the size (total number of rows) corresponding
	 * to the key present in the MMultiData.
	 * If the key does not exist, it returns 0.
	 * MMultiData에 존재하는 key에 해당하는 size(row의 총 수)를 리턴한다.
	 * 키가 존재하지 않으면 , 0을 리턴한다.
	 * 
	 * @return int
	 *
	 * @see    #getDataCount()
	 */
	public int getDataCount(Object key) {
		return this.size();
	}
	
	/**
	 * Check if key exists
	 * 
	 * @param  key target key
	 *
	 * @return     true - exist
	 *             false - not exist
	 */
	public boolean containsKey(Object key) {
		
		if (this.size() == 0) {
			return false;
		} else {
			return containsKey(0, key);
		}
		
	}
	
	/**
	 * Check if key exists
	 * 
	 * @param  index index
	 * @param  key   target key
	 *
	 * @return       true - exist
	 *               false - not exist
	 */
	public boolean containsKey(int index, Object key) {
		
		if (index >= this.size()) {
			return false;
		} else {
			return get(index).containsKey(key);
		}
		
	}
}
