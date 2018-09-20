package assignment2;

import java.util.ArrayList;




public class RemoveList_Q5 {

	ArrayList<String> d = null;
	
	
	
	public RemoveList_Q5 (ArrayList<String> a) {
		super();
		d = new ArrayList<String>(a);
	}
	
	
	
	
	public ArrayList<String> removeAll(ArrayList<String> list){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i=0; i<list.size();++i) {
			String temp1 = list.get(i).toLowerCase();
			for(int j=0; j<d.size();++j) {
				String temp2 = d.get(j).toLowerCase();
				if(temp1.contains(temp2) || temp2.contains(temp1)) {
					temp.add(d.get(j));
				}
			}
		}
		d.removeAll(temp);
		return new ArrayList<String>(d);
	}	
	
	
	
	@Override
	public String toString() {
		return  d + "";
	}

	public ArrayList<String> getD() {
		return d;
	}



	
	
	
	
	
	

	public static void main(String[] args) {
		
		
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("Mango");
		a.add("Banana");
		a.add("Apple");
		a.add("Cataaa");
		a.add("Bants");
		
		RemoveList_Q5 d = new RemoveList_Q5(a);
		
		ArrayList<String> b = new ArrayList<String>();
		
		b.add("Man");
		b.add("Apple");
		b.add("Cat");
		b.add("Ap");
		
		System.out.println(d.removeAll(b));
		System.out.println(d);
		
	
		
	}
	
	
	
	
	
}













