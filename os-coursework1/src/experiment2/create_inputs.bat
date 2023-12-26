cd ..

mkdir classes
javac classes ../src/*.java

cd classes

java InputGenerator ../../experiment2/seed1/input_parameters.prp ../../experiment2/seed1/inputs.in
java InputGenerator ../../experiment2/seed2/input_parameters.prp ../../experiment2/seed2/inputs.in
java InputGenerator ../../experiment2/seed3/input_parameters.prp ../../experiment2/seed3/inputs.in
java InputGenerator ../../experiment2/seed4/input_parameters.prp ../../experiment2/seed4/inputs.in
java InputGenerator ../../experiment2/seed5/input_parameters.prp ../../experiment2/seed5/inputs.in