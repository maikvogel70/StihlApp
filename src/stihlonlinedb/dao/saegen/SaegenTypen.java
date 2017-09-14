package stihlonlinedb.dao.saegen;

import java.util.List;

public abstract class SaegenTypen {

	public List<SaegenTypen> saegenTypenList;

	/**
	 * @return the saegenTypenList
	 */
	public abstract List<SaegenTypen> getSaegenTypenList();

	/**
	 * @param saegenTypenList
	 *            the saegenTypenList to set
	 */
	public abstract void setSaegenTypenList(List<SaegenTypen> saegenTypenList);

}
