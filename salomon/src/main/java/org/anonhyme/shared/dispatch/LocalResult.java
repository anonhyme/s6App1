package org.anonhyme.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;


public class LocalResult implements Result {
	
    private String localType;

 
	public LocalResult() {}
 
    public String getLocalType() {return localType;}
 	public void setLocalType(String localType) {this.localType = localType;}
}
