package JsonMapper.JsonMapper;

import java.util.ArrayList;

public class TraceComplete {
	
	private String dst_addr;
	private String src_addr;
	private ArrayList<ResultO> result;
	public String getDst_addr() {
		return dst_addr;
	}
	public void setDst_addr(String dst_addr) {
		this.dst_addr = dst_addr;
	}
	public String getSrc_addr() {
		return src_addr;
	}
	public void setSrc_addr(String src_addr) {
		this.src_addr = src_addr;
	}
	public ArrayList<ResultO> getResult() {
		return result;
	}
	public void setResult(ArrayList<ResultO> result) {
		this.result = result;
	}
	
	@Override
	public String toString(){
		return "dest_addr: "+this.getDst_addr()+" src_arr"+this.getSrc_addr()+" result: "+this.getResult();
	}

}
