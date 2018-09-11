package cdac.in.nbe;

import java.util.Map;
import java.util.LinkedHashMap;

class Course{

	String courseId;
	String hospitalId;
	String hospitalNameAddress;
	String stateId;
	String specialityCode;
	String speciality;
	String totalSeat;
	int allocated;
	
	Map<String, Quota> quotas;
	
	Course(String courseId, String hospitalId, String stateId, String specialityCode, String totalSeat, int UR, int OBC, int SC, int ST, int PWD, int OBCA, int OBCB,int BC, int BCA, int SCA, int URWo, int STWo, int PWDWo, int BCBWo){

		this.courseId = courseId;
		this.hospitalId = hospitalId;
		this.stateId = stateId;
		this.specialityCode = specialityCode;
		this.totalSeat = totalSeat;
		this.quotas = new LinkedHashMap<String, Quota>();
		
		this.quotas.put("UR", new Quota("UR", UR) );
		this.quotas.put("OBC", new Quota("OBC", OBC) );
		this.quotas.put("SC", new Quota("SC", SC) );
		this.quotas.put("ST", new Quota("ST", ST) );
		this.quotas.put("URWo", new Quota("URWo", URWo) );
		this.quotas.put("PWD", new Quota("PWD", PWD) );
		this.quotas.put("PWDWo", new Quota("PWDWo", PWDWo) );
		this.quotas.put("STWo", new Quota("STWo", STWo) );
		this.quotas.put("OBC-A", new Quota("OBC-A", OBCA) );
		this.quotas.put("OBC-B", new Quota("OBC-B", OBCB) );
		this.quotas.put("BC", new Quota("BC", BC) );
		this.quotas.put("BCA", new Quota("BCA", BCA) );
		this.quotas.put("SCA", new Quota("SCA", SCA) );
		this.quotas.put("BCBWo", new Quota("BCBWo", BCBWo) );
	}
	
	public int getQuotaPriority(String quota)
	{
		return Allocator.quotaPriority.get(quota);
	}
	public String getHospitalNameAddress() {
		return hospitalNameAddress;
	}

	public void setHospitalNameAddress(String hospitalNameAddress) {
		this.hospitalNameAddress = hospitalNameAddress;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	void header(){
		System.out.print("CourseId, HospitalID, State, specialityCode, Total");
		for(String key: quotas.keySet() ){
			System.out.print(", "+key );

		}	
		System.out.println();	
	} 

	void headerCourseStatus(){

		System.out.print("CourseId, HospitalID, State, specialityCode, Total");

		for(String key: quotas.keySet() ){
			System.out.print(", "+key+"-Total, "+key+"-Allocated");

		}	
		System.out.println();	
	}

	void headerCourseOpeningClosingRankStatus(){
		System.out.println("CourseId, HospitalID, State, specialityCode, Total");
		for(String key: quotas.keySet() ){
			System.out.print(", "+key+"-Opening, "+key+"-Closing");

		}	
		System.out.println();	

	}
	
	void headerCourseSeatMatrix(){
		System.out.print("Hospital Id, Hospital Name And Address, State, speciality code, speciality, Total Seat, TotalAccepted");
		for(String key: quotas.keySet() ){
			System.out.print(", "+key+"-Opening, "+key+"-Closing");

		}	
		System.out.println();	
	}
	
	void printStatus(){
		System.out.print(courseId+", "+hospitalId+", "+stateId+", "+specialityCode+", "+totalSeat);
		for(String key: quotas.keySet() ){
			System.out.print(", "+quotas.get( key ).getStatus() );
		}	
		System.out.println();	
	}
	
	void printSeatMatrixStatus(){
		System.out.print(hospitalId +", "+ hospitalNameAddress.replaceAll(",", "")+", "+stateId+", "+specialityCode+", "+speciality+", "+totalSeat+", "+allocated);
		for(String key: quotas.keySet() ){
			System.out.print(", "+quotas.get( key ).getRemainingSeat() );

		}	
		System.out.println();	
	}
	
	void printOpeningClosingRankStatus(){
		System.out.print(courseId+", "+hospitalId+", "+stateId+", "+specialityCode+", "+totalSeat);
		for(String key: quotas.keySet() ){
			System.out.print(", "+quotas.get( key ).getOpeningClosingRank() );

		}	
		System.out.println();
	}
	
	void printNotAllocatedStatus(){
		if(Integer.parseInt(totalSeat) - allocated > 0){
			System.out.print(courseId+", "+hospitalId+", "+stateId+", "+specialityCode+", "+totalSeat);
			for(String key: quotas.keySet() ){
				System.out.print(", "+quotas.get( key ).getStatus() );
			}	
			System.out.println();
		}
	}
	
	void print(){

		boolean flag  = false;
		System.out.print(courseId+", "+hospitalId+", "+stateId+", "+specialityCode+", "+totalSeat);
		for(String key: quotas.keySet() ){
			System.out.print(", "+quotas.get( key ).size );
		}	
		System.out.println();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		return true;
	}
}
