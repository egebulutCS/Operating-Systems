cd ..

mkdir classes
javac classes ../src/*.java

cd classes

java InputGenerator ../../experiment3/seed1/input_parameters.prp ../../experiment3/seed1/inputs.in
java InputGenerator ../../experiment3/seed2/input_parameters.prp ../../experiment3/seed2/inputs.in
java InputGenerator ../../experiment3/seed3/input_parameters.prp ../../experiment3/seed3/inputs.in
java InputGenerator ../../experiment3/seed4/input_parameters.prp ../../experiment3/seed4/inputs.in
java InputGenerator ../../experiment3/seed5/input_parameters.prp ../../experiment3/seed5/inputs.in