package bankPackage;

public class Transaction {
	int tranxId;
	double tranxAmount;
	
	public Transaction(int tranxId, double tranxAmount) {
		super();
		this.tranxId = tranxId;
		this.tranxAmount = tranxAmount;
	}
	public int getTranxId() {
		return tranxId;
	}
	public void setTranxId(int tranxId) {
		this.tranxId = tranxId;
	}
	public double getTranxAmount() {
		return tranxAmount;
	}
	public void setTranxAmount(double tranxAmount) {
		this.tranxAmount = tranxAmount;
	}
	
}
