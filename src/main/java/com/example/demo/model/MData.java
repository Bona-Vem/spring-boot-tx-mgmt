package com.example.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * grid01
 */
public class MData extends LinkedHashMap<String, Object> implements MDataProtocol {
	private static final long serialVersionUID = -5861114305569703387L;
	
	public MData() {}
	
	public MData(Map<String, Object> map) {
		super(map);
	}
	
	public String getString(String key) {
		
		if (get(key) != null) {
			return String.valueOf(get(key)).trim();
		}
		
		return null;
	}
	
	public BigDecimal getBigDecimal(String key) {
		
		if (get(key) != null && !getString(key).isEmpty()) {
			return new BigDecimal(getString(key));
		}
		
		return BigDecimal.ZERO;
	}
	
	public long getLong(String key) {
		
		if (get(key) != null) {
			return Long.parseLong(getString(key));
		}
		
		return 0L;
	}
	
	public int getInt(String key) {
		
		if (get(key) != null) {
			return Integer.parseInt(getString(key));
		}
		
		return 0;
	}
	
	public boolean getBoolean(String key) {
		
		if (get(key) != null) {
			return Boolean.parseBoolean(getString(key));
		}
		
		return false;
	}
	
	public short getShort(String key) {
		
		if (get(key) != null) {
			return Short.parseShort(getString(key));
		}
		
		return 0;
	}
	
	public double getDouble(String key) {
		
		if (get(key) != null) {
			return Double.parseDouble(getString(key));
		}
		
		return 0.0D;
	}
	
	public float getFloat(String key) {
		
		if (get(key) != null) {
			return Float.parseFloat(getString(key));
		}
		
		return 0.0F;
	}
	
	public void set(String key, Object value) {
		this.put(key, value);
	}
	
	public void setMData(String key, MData value) {
		this.put(key, value);
	}
	
	public void setMMultiData(String key, MMultiData value) {
		this.put(key, value);
	}
	
	public void setString(String key, String value) {
		this.put(key, value);
	}
	
	public void setBigDecimal(String key, BigDecimal value) {
		this.put(key, value);
	}
	
	public void setLong(String key, long value) {
		this.put(key, value);
	}
	
	public void setInt(String key, int value) {
		this.put(key, value);
	}
	
	public void setBoolean(String key, boolean value) {
		this.put(key, value);
	}
	
	public void setShort(String key, short value) {
		this.put(key, value);
	}
	
	public void setDouble(String key, double value) {
		this.put(key, value);
	}
	
	public void setFloat(String key, float value) {
		this.put(key, value);
	}
	
	public void appendFrom(MData data) {
		this.putAll(data);
	}
	
	@SuppressWarnings({"unchecked"})
	public MData getMData(String key) {
		
		try {
			Object obj = get(key);
			
			if (obj instanceof MData) {
				return (MData)obj;
			} else if (obj instanceof LinkedHashMap) {
				return new MData((LinkedHashMap<String, Object>)obj);
			} else {
				return obj == null ? new MData() : (MData)obj;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new MData();
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<MData> getListMData(String key) {
		
		try {
			Object obj = get(key);
			
			if (obj instanceof List) {
				return (List<MData>)obj;
			} else if (obj instanceof ArrayList) {
				return new ArrayList((List<LinkedHashMap<String, Object>>)obj);
			} else {
				return obj == null ? new ArrayList<>() : (List<MData>)obj;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	@SuppressWarnings({"unchecked"})
	public MMultiData getMMultiData(String key) {
		
		try {
			Object obj = get(key);
			
			if (obj instanceof MMultiData) {
				return (MMultiData)obj;
			} else if (obj instanceof ArrayList) {
				return new MMultiData((List<LinkedHashMap<String, Object>>)obj);
			} else {
				return obj == null ? new MMultiData() : (MMultiData)obj;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new MMultiData();
	}
}
