package cz.kofron.storage.protocol.request;

import java.io.Serializable;

import cz.kofron.storage.business.service.IStorageFacadeService;
import cz.kofron.storage.protocol.service.IResponseService;

public abstract class Request implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1711357546684855149L;
	
	public abstract void execute(IStorageFacadeService facade, IResponseService responseService);
}
