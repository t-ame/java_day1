package assignments;

import java.util.Scanner;

import assignments.VotePoller;
import assignments.VotePoller.votingState;



public class VotingMain {
	
	public static Voter getVote(boolean president) {
		
		Scanner scanner = new Scanner(System.in);
		int vote =-1;
		int id =-1;
		Voter voter = new Voter(id, president);
		voter.setInFavour(false);
		
		if(!president) {
			System.out.println("Enter Voters ID:");
			id = Integer.parseInt(scanner.nextLine());
		} else {
			id =0;
		}
//		while(vote != 1 && vote != 0 && vote != 8) {
			System.out.println("Enter vote:\n\t1: In favour.\n\t2: Not in favour.\n\t8: To cancel vote.");
			vote = Integer.parseInt(scanner.nextLine());
//		}
		if(vote ==8) {
			scanner.close();
			return voter;
		} else if (vote ==1) {
			voter = new Voter(id, president);
			voter.setInFavour(true);
		} else if (vote == 2){
			voter = new Voter(id, president);
			voter.setInFavour(false);
		}
		
		scanner.close();
		return voter;
	}
	
	
	
	
	public static void main(String[] args) {
		
		VotePoller poller = new VotePoller();
		
		poller.openVoting();
		
		while(poller.isOpen()) {
			Voter voter = getVote(false);
			if(voter != null) {
				poller.vote(voter,voter.isInFavour(), (poller.getPeriod() >= 1l)); //change to 15
			}
		}
		
		if(poller.getState() == votingState.TIED) {
			System.out.println("Enter vote for Vice-President:");
			Voter voter = getVote(true);
			poller.vote(voter, voter.isInFavour(), true);
		}
		
		poller.closeVoting(true);
	}
	
	
}
