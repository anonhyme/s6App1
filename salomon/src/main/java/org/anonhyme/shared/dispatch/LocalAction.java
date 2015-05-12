package org.anonhyme.shared.dispatch;


import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

public class LocalAction extends UnsecuredActionImpl<LocalResult> {
	
    private String local;

    public LocalAction() {}

	public String getLocal() {return local;}
	public void setLocal(String local) {this.local = local;}

}

 

