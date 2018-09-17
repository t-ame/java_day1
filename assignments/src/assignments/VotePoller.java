package assignments;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;




public class VotePoller {

	static private final int maxVotes = 101;
	static private int noOfVotes;
	static private Map<String, Integer> votes;
	private Set<Integer> votersID=new HashSet<Integer>();
	
	LocalDateTime startTime;
	LocalDateTime endTime;
	
	public enum votingState{
		OPEN, CLOSED, TIED, FULL
	}
	private votingState state = votingState.CLOSED;
	
	
	public VotePoller() {
		super();
		votes = new HashMap<String, Integer>();
		votes.put("Yes", 0);
		votes.put("No", 0);
	}
	
	
	public void openVoting() {
		state = votingState.OPEN;
		startTime = LocalDateTime.now();
	}
	
	public void closeVoting(boolean ignoreTied) {
		if(votes.get("Yes") == votes.get("No") && !ignoreTied) {
			enterTied();
		} else {
			this.state = votingState.CLOSED;
			endTime = LocalDateTime.now();
			printResults();
		}
	}
	
	public boolean vote(Voter voter, boolean inFavour, boolean canClose) {
		if(voter == null || voter.getId()<0) {
			return false;
		}
		if(this.state == votingState.OPEN) {
			if(votersID.add(voter.getId())) {
				if(inFavour) {
					votes.put("Yes", votes.get("Yes")+1);
				} else {
					votes.put("No", votes.get("No")+1);
				}
				++noOfVotes;
				checkValid(canClose);
				return true;
			} else {
				System.out.println("Each voter can only vote once.");
				return false;
			}
		} else if (this.state == votingState.TIED && voter.isPresident()){
			if(inFavour) {
				votes.put("Yes", votes.get("Yes")+1);
			} else {
				votes.put("No", votes.get("No")+1);
			}
			++noOfVotes;
			closeVoting(true);
			return true;
		} else {
			checkValid(canClose);
			return false;	
		}
	}
	
	
	//Display result of voting
	//called when voting is closed...
	public void printResults() {
		System.out.println("Voting Closed.\n");
		System.out.println("-----------------------------------\n");
		if(votes.get("Yes") > votes.get("No")) {
			System.out.println("Motion PASSED!");
		} else {
			System.out.println("Motion FAILED!");
		}
		System.out.println(votes.get("Yes") +  " voters voted for this motion.");
		System.out.println(votes.get("No") +  " voters voted against this motion.");
		System.out.println("Voting opened by: "+startTime + ", and closed by: " +endTime );
	}
	
	
	public long getPeriod() {
		return startTime.until(LocalDateTime.now(), ChronoUnit.MINUTES);
	}
	
	private void checkValid(boolean canClose) {
		if(this.state != votingState.CLOSED && noOfVotes >= maxVotes) {
			if(canClose) {
				closeVoting(false);	
			} else {
				this.state = votingState.FULL;
			}
		}
	}

	private void enterTied() {
		this.state = votingState.TIED;
	}
	
	public boolean isOpen() {
		return state == votingState.OPEN;
	}
	
	public static int getMaxvotes() {
		return maxVotes;
	}
	
	public static int getNoOfVotes() {
		return noOfVotes;
	}

	public votingState getState() {
		return state;
	}

	public void setState(votingState state) {
		this.state = state;
	}
	
}
