#include <iostream>
#include <iomanip>
using namespace std; 

int main() {
  double enteredTemperature; 
 int temperatureInTenMins; 
int temperatureInThirtyMins;
  
  cout <<  setw(12) << right <<  "outside temperature in degrees Fahrenheit " ; 

  cin >> enteredTemperature; 
  cout << endl; 
  if (enteredTemperature < 70) { 
    
    cout <<  setw(12) << right <<  "below the range of concern"; 

    } else if ((enteredTemperature < 100) && (enteredTemperature >= 70)) 
  { 
    
    if ( (enteredTemperature >=70) && (enteredTemperature < 75)) {

    temperatureInTenMins = 89;
    temperatureInThirtyMins = 104; 

   
    }else if ( (enteredTemperature >=75) && (enteredTemperature < 80)) {

    temperatureInTenMins = 94;
    temperatureInThirtyMins = 109; 
    
      }else if ( (enteredTemperature >=80) && (enteredTemperature < 85)) {

    temperatureInTenMins = 99;
    temperatureInThirtyMins = 114; 
      }
    else if ( (enteredTemperature >=85) && (enteredTemperature < 90)) {

    temperatureInTenMins = 104;
    temperatureInThirtyMins = 119; 
      }
    else if ( (enteredTemperature >=90) && (enteredTemperature < 95)) {

    temperatureInTenMins = 109;
    temperatureInThirtyMins = 124; 
      }
    else if ( (enteredTemperature >=95) && (enteredTemperature < 100)) {

    temperatureInTenMins = 114;
    temperatureInThirtyMins = 129; 
      }

    


    cout << "|"; 
    cout << right << setw(12) << "Elapsed" << " "; 
     cout << right << setw(15) << "Approximate" << right << "|" << endl;
    
    cout << "|"; 
     cout << right << setw(12) << "Time in Mins" << "|"; 
      cout << right << setw(15) << "Temp in Degrees"<< "|" << endl;
 cout << "|"; 
     cout << right << setw(12) << "" << "|"; 
      cout << right << setw(15) << ""<< "|" << endl;

    

     
    cout << "|"; 
     cout << right << setw(12) << "10" << "|"; 
      cout << right << setw(15) << temperatureInTenMins << "|" << endl;
  
    cout << "|"; 
     cout << right << setw(12) << "30" << "|"; 
      cout << right << setw(15) << temperatureInThirtyMins << "|" << endl;
    
    
    }
  else if (enteredTemperature > 100) { 
    cout << "Temperature is exessive should not be left in car for any duration!\n"; 
    }
}