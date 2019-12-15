package com.example.projectandroid;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectandroid.employee.Manager;
import com.example.projectandroid.employee.Programmer;
import com.example.projectandroid.employee.Tester;
import com.example.projectandroid.vehicle.Car;
import com.example.projectandroid.vehicle.MotorCycle;
import com.example.projectandroid.vehicle.Vehicle;

public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private EditText edFirstName;
    private EditText edLastName;
    private EditText edBirthYear;
    private EditText edMonthlySalary;
    private EditText edOccupationRate;
    private EditText edEmployeeId;
    private Spinner spEmployeeType;
    private LinearLayout panelNb;
    private TextView tvLabelNb;
    private EditText edNumber;

    private LinearLayout panelCarType;
    private LinearLayout panelSideCar;
    private EditText edCarType;
    private EditText edVehicleModel;
    private EditText edPlateNumber;

    private String vehicleType = "";
    private Boolean isSideCar = false;
    private String vehicleColor = "";
    private RadioGroup rgVehicleType;
    private RadioGroup rgSideCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edFirstName = findViewById(R.id.edFirstName);
        edLastName = findViewById(R.id.edLastName);
        edBirthYear = findViewById(R.id.edBirthYear);
        edEmployeeId = findViewById(R.id.edEmployeeId);
        edMonthlySalary = findViewById(R.id.edMonthlySalary);
        edOccupationRate = findViewById(R.id.edOccupationRate);
        spEmployeeType = findViewById(R.id.spEmployeeType);
        panelNb = findViewById(R.id.panelNb);
        tvLabelNb = findViewById(R.id.tvLabelNb);
        edNumber = findViewById(R.id.edNumber);
        rgVehicleType = findViewById(R.id.rgVehicleType);
        panelCarType = findViewById(R.id.panelCarType);
        panelSideCar = findViewById(R.id.panelSideCar);
        edCarType = findViewById(R.id.edCarType);
        rgSideCar = findViewById(R.id.rgSideCar);

        edVehicleModel = findViewById(R.id.edVehicleModel);
        edPlateNumber = findViewById(R.id.edPlateNumber);
        Spinner spVehicleColor = findViewById(R.id.spVehicleColor);
        Button btnRegister = findViewById(R.id.btnRegister);


        spEmployeeType.setOnItemSelectedListener(this);
        spVehicleColor.setOnItemSelectedListener(this);
        rgVehicleType.setOnCheckedChangeListener(this);
        rgSideCar.setOnCheckedChangeListener(this);
        btnRegister.setOnClickListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String value = parent.getAdapter().getItem(position).toString();
        Log.e("SpinnerValue", value);

        switch (parent.getId()) {
            case R.id.spEmployeeType:
                panelNb.setVisibility(View.VISIBLE);
                switch (value) {
                    case "Manager":
                        tvLabelNb.setText("# client");
                        break;
                    case "Programmer":
                        tvLabelNb.setText("# projects");
                        break;
                    case "Tester":
                        tvLabelNb.setText("# bugs");
                        break;
                    default:
                        panelNb.setVisibility(View.GONE);
                        break;
                }
                break;
            case R.id.spVehicleColor:
                Log.e("VehicleColor", value);
                vehicleColor = value;
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group.getId() == R.id.rgVehicleType) {
            panelCarType.setVisibility(View.GONE);
            panelSideCar.setVisibility(View.GONE);
            //Vehicle Type Radio Group
            if (checkedId == R.id.rbCar) {//Car Selected
                vehicleType = "Car";
                panelCarType.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbMotorBike) {//MotorCycle Selected
                vehicleType = "MotorBike";
                panelSideCar.setVisibility(View.VISIBLE);
            }
            Log.e("VehicleType", vehicleType);
        } else if (group.getId() == R.id.rgSideCar) {

            if (checkedId == R.id.rbYes) {
                isSideCar = true;
            } else if (checkedId == R.id.rbNo) {
                isSideCar = false;
            }
            Log.e("SideCar", isSideCar + "");
        }
    }

    @Override
    public void onClick(View v) {
        String firstName = getEditTextValue(edFirstName);
        String lastName = getEditTextValue(edLastName);
        String birthYear = getEditTextValue(edBirthYear);
        String monthlySalary = getEditTextValue(edMonthlySalary);
        String occupationRate = getEditTextValue(edOccupationRate);
        String employeeType = spEmployeeType.getAdapter().getItem(spEmployeeType.getSelectedItemPosition()).toString();
        String number = getEditTextValue(edNumber);
        String carType = getEditTextValue(edCarType);
        String vehicleModel = getEditTextValue(edVehicleModel);
        String plateNumber = getEditTextValue(edPlateNumber);
        String employeeId = getEditTextValue(edEmployeeId);

        if (TextUtils.isEmpty(firstName)) {
            makeToast("Enter First Name");
            return;
        } else if (TextUtils.isEmpty(lastName)) {
            makeToast("Enter Last Name");
            return;
        } else if (TextUtils.isEmpty(birthYear + "")) {
            makeToast("Enter Birth Year");
            return;
        } else if (Integer.parseInt(birthYear) == 0 || birthYear.length() < 4) {
            makeToast("Enter Valid Birth Year");
            return;
        } else if (TextUtils.isEmpty(monthlySalary + "")) {
            makeToast("Enter monthly salary");
            return;
        } else if (Integer.parseInt(monthlySalary) == 0) {
            makeToast("Enter valid monthly salary");
            return;

        } else if (employeeType.equals("Choose a type")) {
            makeToast("Select Employee type");
            return;
        } else if (TextUtils.isEmpty(number)) {
            makeToast("Enter number");
            return;
        } else if (rgVehicleType.getCheckedRadioButtonId() == -1) {
            makeToast("Select Vehicle Type");
            return;
        } else if (rgVehicleType.getCheckedRadioButtonId() == R.id.rbCar && TextUtils.isEmpty(carType)) {
            makeToast("Enter car type");
            return;
        } else if (rgVehicleType.getCheckedRadioButtonId() == R.id.rbMotorBike && rgSideCar.getCheckedRadioButtonId() == -1) {
            makeToast("Select Side Car");
            return;
        } else if (vehicleColor.equals("Choose a color")) {
            makeToast("Select color");
            return;
        }
        if (occupationRate.equals("")) {
            occupationRate = "100"; //Default Rate
        }

        Vehicle vehicle;
        if (vehicleType.equals("Car")) {
            vehicle = new Car(vehicleModel, plateNumber, vehicleColor, vehicleType, carType);
        } else {
            vehicle = new MotorCycle(vehicleModel, plateNumber, vehicleColor, vehicleType, isSideCar);
        }

        if (employeeId.equals("")) {
            employeeId = "0";
        }
        switch (employeeType) {
            case "Manager":
                AppData.employees.add(new Manager(firstName, lastName, Integer.parseInt(birthYear), Double.parseDouble(monthlySalary),
                        Integer.parseInt(occupationRate), Integer.parseInt(employeeId), vehicle, Integer.parseInt(number)));
                break;
            case "Programmer":
                AppData.employees.add(new Programmer(firstName, lastName, Integer.parseInt(birthYear), Double.parseDouble(monthlySalary),
                        Integer.parseInt(occupationRate), Integer.parseInt(employeeId), vehicle, Integer.parseInt(number)));
                break;
            case "Tester":
                AppData.employees.add(new Tester(firstName, lastName, Integer.parseInt(birthYear), Double.parseDouble(monthlySalary),
                        Integer.parseInt(occupationRate), Integer.parseInt(employeeId), vehicle, Integer.parseInt(number)));
                break;
        }
        finish();

    }


    private void makeToast(String messgae) {
        Toast.makeText(this, messgae, Toast.LENGTH_SHORT).show();
    }

    private String getEditTextValue(EditText editTxt) {
        return editTxt.getText().toString().trim();
    }
}
