# See-Saw Simulator

Class project for Chapman CPSC-380 (Operating Systems).

The purpose of this project is to emulate the motion of a see-saw.
This program uses multiple threads and semaphores to control access to variables.

Fred and Wilma are on a see-saw, with Fred starting at the bottom.
Fred pushes off at 1 ft/sec and Wilma pushes off at 1.5 ft/sec.
Whenever one person comes within 1 ft of the ground, they push back up, causing the other person to go down.
The maximum height any person can go is 7 ft.

Two threads are created and two binary semaphores are created to control access to shared storage of height values.
Each thread executes 10 times (10 up-down motions of the see-saw).
