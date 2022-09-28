package leetCodeContest.contest307;



/**
 * first problem of the leetcode contest 307
 */
public class MinNumberOfHours {


	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

		int energyNeeded = 0 ;
		int experienceNeeded = 0 ;

		for (int i = 0 ; i < energy.length ; i++){
			energyNeeded += energy[i] ;
			if( initialExperience <=  experience[i]){
				experienceNeeded += (experience[i] - initialExperience + 1) ;
				initialExperience += (experience[i] - initialExperience + 1)  ;
			}

			initialExperience += experience[i] ;
		}

		if(initialEnergy  > energyNeeded ) return experienceNeeded ;
		else {
			return (energyNeeded - initialEnergy + 1) + experienceNeeded ;
		}
	}

	public static void main(String[] args) {
		int[] energy = new int[] {1,4,3,2} ;
		int[] experience = new int[] {2,6,3,1} ;
		int initialExperice = 3  ;
		int initialEnergy = 5 ;

		int minHours = new MinNumberOfHours().minNumberOfHours(initialEnergy, initialExperice, energy, experience) ;

		System.out.println(minHours );
	}
}
