package predictive;

public class Words2SigProto  {
	
	public static void main(String[] args) {
		
			for (int i=0;i<args.length;i++) {
				
				System.out.println(args[i] + " = " + PredictivePrototype.wordToSignature(args[i]));
				
		      
		    }       
	}
}
