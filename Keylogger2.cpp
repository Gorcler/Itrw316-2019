#include <windows.h>
#include <iostream>
#include <string>
#include <fstream>


using namespace std;

string currentSentence;

char alphabet[] = { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
char Alphabet[] = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };

int main()
{
	ofstream myfile;
	myfile.open("myfile.txt");
	int x = false;
	int y = true;
	int i = 0;
	int j = 0;
	string p; 

	cout << "KeyCombo ctr-shift-s\n";
	while (y)
	{
		if (GetAsyncKeyState(VK_CONTROL) & GetAsyncKeyState(VK_SHIFT) & GetAsyncKeyState(0x53))
		{
			y = false;
			x = true;
			Sleep(2000);
		}
	}

	while (x)
	{
		Sleep(1);
		
		DWORD keyCode = 0x41;

		if (GetAsyncKeyState(VK_LEFT) & 1)
		{
			i = i - 5;
			SetCursorPos(i, j);
			Sleep(5);
			x = true;
		}
		if (GetAsyncKeyState(VK_RIGHT) & 1)
		{
			i = i + 5;
			SetCursorPos(i, j);
			Sleep(5);
			x = true;
		}
		if (GetAsyncKeyState(VK_DOWN) & 1)
		{
			j = j + 5;
			SetCursorPos(i, j);
			Sleep(5);
			x = true;
		}

		if (GetAsyncKeyState(VK_UP) & 1)
		{
			j = j - 5;
			SetCursorPos(i, j);
			Sleep(5);
			x = true;
		}
	
		for (int i = 0; i < 26; i++)
		{
			if (GetAsyncKeyState(keyCode) & 1)
			{
				if (GetAsyncKeyState(VK_SHIFT))
				{
					currentSentence += Alphabet[i];
				}
				else
				{
					currentSentence += alphabet[i];
					cout << alphabet[i];
				}
			}

			if (GetAsyncKeyState(VK_SPACE) & 1)
			{
				currentSentence += " ";
			}
			if (GetAsyncKeyState(VK_BACK) & 1)
			{
				currentSentence = currentSentence.substr(0, currentSentence.size() - 1);
			}

			keyCode += 1;

			if (GetAsyncKeyState(VK_RETURN) & 1)
			{
				myfile << currentSentence << endl;
				currentSentence = "";
			}	
		}

		if (GetAsyncKeyState(VK_CONTROL) & GetAsyncKeyState(VK_SHIFT) & GetAsyncKeyState(0x53))
		{
			myfile << currentSentence << endl;
			x = false;
			cout << " End";
		}
	}
	myfile.close();
}