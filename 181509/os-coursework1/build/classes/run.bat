
mkdir classes
javac classes ../src/*.java

cd classes

for i in {1..3}
do
java InputGenerator ../../experiment1/seed$i/input_parameters_1.prp ../../experiment1/seed$i/inputs1.in
java InputGenerator ../../experiment1/seed$i/input_parameters_2.prp ../../experiment1/seed$i/inputs2.in
java InputGenerator ../../experiment1/seed$i/input_parameters_3.prp ../../experiment1/seed$i/inputs3.in
java InputGenerator ../../experiment1/seed$i/input_parameters_4.prp ../../experiment1/seed$i/inputs4.in
java InputGenerator ../../experiment1/seed$i/input_parameters_5.prp ../../experiment1/seed$i/inputs5.in

done

for i in {1..3}
do
java Simulator ../../experiment1/seed$i/simulator_parameters_fcfs.prp ../../experiment1/seed$i/output1.out ../../experiment1/seed$i/inputs1.in
java Simulator ../../experiment1/seed$i/simulator_parameters_fcfs.prp ../../experiment1/seed$i/output2.out ../../experiment1/seed$i/inputs2.in
java Simulator ../../experiment1/seed$i/simulator_parameters_fcfs.prp ../../experiment1/seed$i/output3.out ../../experiment1/seed$i/inputs3.in
java Simulator ../../experiment1/seed$i/simulator_parameters_fcfs.prp ../../experiment1/seed$i/output4.out ../../experiment1/seed$i/inputs4.in
java Simulator ../../experiment1/seed$i/simulator_parameters_fcfs.prp ../../experiment1/seed$i/output5.out ../../experiment1/seed$i/inputs5.in

done