package com.intelligrated.download.mapping;

import com.intelligrated.download.entity.DataObject;

public interface Mapper {
	public DataObject map(String line);
}
