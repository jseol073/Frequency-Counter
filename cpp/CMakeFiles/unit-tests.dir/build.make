# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.11

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CMake.app/Contents/bin/cmake

# The command to remove a file.
RM = /Applications/CMake.app/Contents/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp

# Include any dependencies generated for this target.
include CMakeFiles/unit-tests.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/unit-tests.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/unit-tests.dir/flags.make

CMakeFiles/unit-tests.dir/test/test.cpp.o: CMakeFiles/unit-tests.dir/flags.make
CMakeFiles/unit-tests.dir/test/test.cpp.o: test/test.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/unit-tests.dir/test/test.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/unit-tests.dir/test/test.cpp.o -c /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/test/test.cpp

CMakeFiles/unit-tests.dir/test/test.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/unit-tests.dir/test/test.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/test/test.cpp > CMakeFiles/unit-tests.dir/test/test.cpp.i

CMakeFiles/unit-tests.dir/test/test.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/unit-tests.dir/test/test.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/test/test.cpp -o CMakeFiles/unit-tests.dir/test/test.cpp.s

CMakeFiles/unit-tests.dir/src/main.cpp.o: CMakeFiles/unit-tests.dir/flags.make
CMakeFiles/unit-tests.dir/src/main.cpp.o: src/main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/unit-tests.dir/src/main.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/unit-tests.dir/src/main.cpp.o -c /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/src/main.cpp

CMakeFiles/unit-tests.dir/src/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/unit-tests.dir/src/main.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/src/main.cpp > CMakeFiles/unit-tests.dir/src/main.cpp.i

CMakeFiles/unit-tests.dir/src/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/unit-tests.dir/src/main.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/src/main.cpp -o CMakeFiles/unit-tests.dir/src/main.cpp.s

# Object files for target unit-tests
unit__tests_OBJECTS = \
"CMakeFiles/unit-tests.dir/test/test.cpp.o" \
"CMakeFiles/unit-tests.dir/src/main.cpp.o"

# External object files for target unit-tests
unit__tests_EXTERNAL_OBJECTS =

unit-tests: CMakeFiles/unit-tests.dir/test/test.cpp.o
unit-tests: CMakeFiles/unit-tests.dir/src/main.cpp.o
unit-tests: CMakeFiles/unit-tests.dir/build.make
unit-tests: CMakeFiles/unit-tests.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable unit-tests"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/unit-tests.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/unit-tests.dir/build: unit-tests

.PHONY : CMakeFiles/unit-tests.dir/build

CMakeFiles/unit-tests.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/unit-tests.dir/cmake_clean.cmake
.PHONY : CMakeFiles/unit-tests.dir/clean

CMakeFiles/unit-tests.dir/depend:
	cd /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp /Users/johnseol/cs_126/CLionProjects/frequencycount-jseol073/cpp/CMakeFiles/unit-tests.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/unit-tests.dir/depend

