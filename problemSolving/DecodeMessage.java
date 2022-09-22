package problemSolving;

public class DecodeMessage {

	public static int waysToDecode(String cipher ){
		if(cipher.length() == 1 ) {
			return 1 ;
		} else if (cipher.length() == 2) {
			if (Integer.parseInt(cipher) > 26){
				return 2 ;
			}else {
				return 3 ;
			}
		}
		if( Integer.parseInt( cipher.substring(0, 1)) > 26 ){
			return 1 + waysToDecode(cipher.substring(1) ) ;

		}
		return 2 + waysToDecode(cipher.substring(2) ) ;
	}

	public static void main(String[] args) {
		int nbways = waysToDecode("12345") ;

		System.out.println(nbways);
	}
}
