javac cdac/in/nbe/Allocator.java 
#java cdac.in.nbe.Allocator -a ../cet-data/cet-applicant.csv -c ../cet-data/seatmatrix.csv -lr ../cet-data/cet-lastround-applicant.csv -r 2 -rs > ../cet-data/vacancy-matrix-cet.csv
java cdac.in.nbe.Allocator -a ../cet-data/cet-applicant.csv -c ../cet-data/seatmatrix.csv -lr ../cet-data/cet-lastround-applicant.csv -r 2 -tv > ../cet-data/allocation-cet.csv
java cdac.in.nbe.Allocator -a ../cet-data/cet-applicant.csv -c ../cet-data/seatmatrix.csv -lr ../cet-data/cet-lastround-applicant.csv -r 2 -cs > ../cet-data/course-status-cet.csv
java cdac.in.nbe.Allocator -a ../cet-data/cet-applicant.csv -c ../cet-data/seatmatrix.csv -lr ../cet-data/cet-lastround-applicant.csv -r 2 -dnb > ../cet-data/nbe-view-cet.csv

