package org.maruhan.persistence;

import java.util.List;

public interface CRUDMapper<V,K> {

	public void create(V vo) throws Exception;
	public V read(int bno) throws Exception;
	public void delete(int bno) throws Exception;
	public void update(V vo) throws Exception;
	public List<V> listAll() throws Exception;
}
