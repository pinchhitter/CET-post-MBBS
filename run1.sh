javac cdac/in/nbe/Allocator.java 
java cdac.in.nbe.Allocator -a ../cet-data/cet-applicant.csv -c ../cet-data/seatmatrix.csv  -r 1 -tv > ../cet-data/allocation-cet.csv
java cdac.in.nbe.Allocator -a ../cet-data/cet-applicant.csv -c ../cet-data/seatmatrix.csv  -r 1 -cs > ../cet-data/course-status-cet.csv
java cdac.in.nbe.Allocator -a ../cet-data/cet-applicant.csv -c ../cet-data/seatmatrix.csv  -r 1 -dnb > ../cet-data/nbe-view-cet.csv

