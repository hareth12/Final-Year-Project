package uob.service;

public class CombinedService {
	private FDClientService fdcs;
	private RBKClientService rbkcs;
	
	public CombinedService(){
		fdcs=new FDClientService();
		rbkcs=new RBKClientService();
	}
	
	public boolean transferRBKtoFD(long RBKnumber, long FDnumber, double amount){
		System.out.println("RBK= "+RBKnumber+" FD = "+ FDnumber+" amount= "+amount);
		if(rbkcs.withdraw(RBKnumber, amount)>0){
			if(fdcs.deposit(FDnumber, amount)>0){
				return true;
			}
			else{
				rbkcs.deposit(RBKnumber, amount);
				return false;
			}
		}
		return false;
	}
	
	public boolean transferFDtoRBK(long RBKnumber, long FDnumber, double amount){
		System.out.println("RBK= "+RBKnumber+" FD = "+ FDnumber+" amount= "+amount);
		if(fdcs.withdraw(FDnumber, amount)>0){
			if(rbkcs.deposit(RBKnumber, amount)>0){
				return true;
			}
			else{
				fdcs.deposit(FDnumber, amount);
				return false;
			}
		}
		
		
		return false;
	}
}
