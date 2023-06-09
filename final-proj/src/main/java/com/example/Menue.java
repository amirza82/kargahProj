package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menue {
    private List<Person> result = new ArrayList<>();

    public <T> void startHispital(T human) {
        Scanner inputInt = new Scanner(System.in);
        boolean test = true;
        while (test) {
            if (human instanceof Nurse || human instanceof Doctor) {
                test = true;
                System.out.println("1. View Patient List");
                System.out.println("2. View Doctor List");
                if (human instanceof Doctor) {
                    System.out.println("3. Change Patient Description");
                    System.out.println("4. Visit");
                    System.out.println("5. Add Patient");
                    System.out.println("6. Discharge Patient");
                }
                System.out.println("0. Back");
                try {
                    int number = inputInt.nextInt();
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    switch (number) {
                        case 1:
                            View_Patient_List();
                            break;

                        case 2:
                            View_Doctor_List();
                            break;

                        case 3:
                            if (human instanceof Doctor) {
                                Change_Patient_Description((Doctor) human);
                            } else
                                System.out.println("The number is not allowed!!!!!" + "\n");
                            break;

                        case 4:
                            if (human instanceof Doctor) {
                                Visit((Doctor) human);
                            } else
                                System.out.println("The number is not allowed!!!!!" + "\n");

                            break;

                        case 5:
                            if (human instanceof Doctor) {
                                Add_Patient();
                            } else
                                System.out.println("The number is not allowed!!!!!" + "\n");

                            break;
                        case 6:
                            if (human instanceof Doctor) {
                                Discharge_Patient((Doctor) human);
                            } else
                                System.out.println("The number is not allowed!!!!!" + "\n");

                            break;

                        case 0:
                            test = false;
                            break;

                        default:
                            System.out.println("The number is not allowed!!!!!" + "\n");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("The number is not allowed!!!!!" + "\n");
                }
            }
            if (human instanceof Admin) {
                try {
                    test = true;
                    System.out.println("1. View Patient List");
                    System.out.println("2. View Doctors List");
                    System.out.println("3. View Nurse List");
                    System.out.println("4. Remove Clinic member");
                    System.out.println("5. Add Clinic member");
                    System.out.println("0. Back");
                    int number = inputInt.nextInt();
                    switch (number) {
                        case 1:
                            View_Patient_List();
                            break;

                        case 2:
                            View_Doctor_List();
                            break;

                        case 3:
                            View_Nurse_List();
                            break;

                        case 4:
                            Remove_Clinic_member();
                            break;
                        case 5:
                            Add_Clinic_member();
                            break;

                        case 0:
                            test = false;
                            break;

                        default:
                            System.out.println("The number is not allowed!!!!!" + "\n");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("The number is not allowed!!!!!" + "\n");
                }
            }
        }
    }

    public void Discharge_Patient(Doctor human) {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        System.out.println("Enter the Patient's Name: ");
        String name = inputString.nextLine();
        System.out.println("Enter the Patient's ID:");
        int ID = inputInt.nextInt();
        Person patient = Hospital.getPatientByID(ID);
        if (patient != null) {
            Hospital.discharge(human, (Patient) patient);
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("The Patient " + name + " was discharged successfully");
        } else {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("There is no patient with this ID!!!!" + "\n");

        }
    }

    public void Add_Patient() {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        System.out.println("Enter the Patient's Name: ");
        String name = inputString.nextLine();
        System.out.println("Enter the Patient's phoneNumber:");
        String phon = inputString.nextLine();
        System.out.println("Enter the Patient's address:");
        String address = inputString.nextLine();
        System.out.println("Enter the Patient's email:");
        String email = inputString.nextLine();
        System.out.println("Enter the Patient's description:");
        String description = inputString.nextLine();
        Hospital.addPatient(name, phon, email, address, description);
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("Nurse " + name + "'s information was successfully registered" + "\n");
    }

    public void View_Patient_List() {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Scanner inputString2 = new Scanner(System.in);


        boolean check = true;
        boolean print = true;

        System.out.println("\033[H\033[2J");
        System.out.flush();
        boolean checkPatient = true;
        if (Hospital.getPatients().size() != 0) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("-----------------------------------**Patient List**-----------------------------------");
            System.out.println("Enter the Patient's ID to see the prescriptions: " + "\n");
            for (Person pati : Hospital.getPatients())
                if (pati instanceof Patient) {
                    pati.show_prof();
                    System.out.println("\n");
                }
        } else {
            check = false;
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("No Patient has been registered yet" + "\n");
        }
        while (checkPatient) {
            if (check == false) {
                if (Hospital.getPatients().size() != 0) {
                    if (print) {
                        System.out.println("-----------------------------------**Patient List**-----------------------------------");
                        System.out.println("Enter the Patient's ID to see the prescriptions: " + "\n");
                        for (Person per : result) {
                            if (per instanceof Patient) {
                                per.show_prof();
                                System.out.println("\n");
                            }
                        }
                    } else if (!print) {
                        System.out.println("-----------------------------------**Patient List**-----------------------------------");
                        for (Person per : result) {
                            if (per instanceof Patient) {
                                if (((Patient) per).getPrescriptions().size() != 0) {
                                    ((Patient) per).show_prescri();
                                    System.out.println("\n");
                                } else {
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println("This Patient doesn't have a prescription!!!" + "\n");
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("No Patient has been registered yet" + "\n");
                }
            } else {
                System.out.println("A. Search By ID");
                System.out.println("B. Search By Name");
            }
            check = true;
            print = true;
            System.out.println("C. Back");
            String choose = inputString.next();
            if (choose.equalsIgnoreCase("A") == true) {
                System.out.println("Enter the Patient ID: ");
                int inputId = inputInt.nextInt();

                result = serach_by_ID(inputId, false);
                if (result.size() == 0) {
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Your search result was not found!!!!" + "\n");
                    check = false;
                } else {
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Search result for Patient with " + inputId + " ID: " + "\n");
                    check = false;
                }

            } else if (choose.equalsIgnoreCase("B") == true) {
                System.out.println("Enter the Patient's Name: ");
                String inputName = inputString2.nextLine();
                result = Hospital.Search_By_Name(Hospital.getPatients(), inputName);
                if (result.size() == 0) {
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Your search result was not found!!!!" + "\n");
                    check = false;
                } else {
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Search result for Patient with " + inputName + " ID: " + "\n");
                    check = false;
                }
            } else if (choose.equalsIgnoreCase("C") == true) {
                checkPatient = false;
            } else if (choose.equalsIgnoreCase("A") != true && choose.equalsIgnoreCase("B") != true
                    && choose.equalsIgnoreCase("C") != true) {
                int id = Integer.parseInt(choose);
                result = serach_by_ID(id, false);
                if (result.size() == 0) {
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("The number is not allowed!!!!!" + "\n");
                    check = false;
                } else {
                    check = false;
                    print = false;
                }
            }

        }
    }

    public void View_Doctor_List() {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Scanner inputString2 = new Scanner(System.in);

        boolean check = true;
        boolean print = true;
        try {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            boolean checkPatient = true;
            if (Hospital.getStaff().size() != 0) {
                System.out.println("-----------------------------------**Doctor List**-----------------------------------");
                System.out.println("Enter the Doctor's ID to see the prescriptions: " + "\n");
                for (Person doct : Hospital.getStaff())
                    if (doct instanceof Doctor) {
                        doct.show_prof();
                        System.out.println("\n");
                    }
            } else {
                check = false;
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("No Doctor has been registered yet" + "\n");
            }
            while (checkPatient) {
                if (check == false) {
                    if (Hospital.getStaff().size() != 0) {
                        if (print) {
                            System.out.println("-----------------------------------**Doctor List**-----------------------------------");
                            System.out.println("Enter the Doctor's ID to see the prescriptions: " + "\n");
                            for (Person per : result) {
                                if (per instanceof Doctor) {
                                    per.show_prof();
                                    System.out.println("\n");
                                }
                            }
                        } else if (!print) {
                            System.out.println("-----------------------------------**Doctor List**-----------------------------------");
                            for (Person per : result) {
                                if (per instanceof Doctor) {
                                    ((Doctor) per).print();
                                    System.out.println("\n");
                                }
                            }
                        }
                    } else {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("No Doctor has been registered yet" + "\n");

                    }
                } else {
                    System.out.println("A. Search By ID");
                    System.out.println("B. Search By Name");
                }
                check = true;
                print = true;
                System.out.println("C. Back");
                String choose = inputString.next();
                if (choose.equalsIgnoreCase("A") == true) {
                    System.out.println("Enter the Doctor ID: ");
                    int inputId = inputInt.nextInt();
                    result = serach_by_ID(inputId, true);
                    if (result.size() == 0) {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Your search result was not found!!!!" + "\n");
                        check = false;
                    } else {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Search result for Doctor with " + inputId + " ID: " + "\n");
                        check = false;
                    }

                } else if (choose.equalsIgnoreCase("B") == true) {
                    System.out.println("Enter the Doctor's Name: ");
                    String inputName = inputString2.nextLine();
                    result = Hospital.Search_By_Name(Hospital.getStaff(), inputName);
                    if (result.size() == 0) {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Your search result was not found!!!!" + "\n");
                        check = false;
                    } else {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Search result for Doctor with " + inputName + " ID: " + "\n");
                        check = false;
                    }
                } else if (choose.equalsIgnoreCase("C") == true) {
                    checkPatient = false;
                } else if (choose.equalsIgnoreCase("A") != true && choose.equalsIgnoreCase("B") != true
                        && choose.equalsIgnoreCase("C") != true) {
                    int id = Integer.parseInt(choose);
                    result = serach_by_ID(id, true);
                    if (result.size() == 0) {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("The number is not allowed!!!!!" + "\n");
                        check = false;
                    } else {
                        check = false;
                        print = false;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("The number is not allowed!!!!!" + "\n");
        }
    }

    public void View_Nurse_List() {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Scanner inputString2 = new Scanner(System.in);

        boolean check = true;
        boolean print = true;
        try {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            boolean checkPatient = true;
            if (Hospital.getStaff().size() != 0) {
                System.out.println("-----------------------------------**Nurse List**-----------------------------------");
                System.out.println("Enter the Nurse's ID to see the prescriptions: " + "\n");
                for (Person nurs : Hospital.getStaff())
                    if (nurs instanceof Nurse) {
                        nurs.show_prof();
                        System.out.println("\n");
                    }
            } else {
                check = false;
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("No Nurse has been registered yet" + "\n");
            }
            while (checkPatient) {
                if (check == false) {
                    if (Hospital.getStaff().size() != 0) {
                        if (print) {
                            System.out.println("-----------------------------------**Nurse List**-----------------------------------");
                            System.out.println("Enter the Nurse's ID to see the prescriptions: " + "\n");
                            for (Person per : result) {
                                if (per instanceof Nurse) {
                                    per.show_prof();
                                    System.out.println("\n");
                                }
                            }
                        } else if (!print) {
                            for (Person per : result) {
                                System.out.println("-----------------------------------**Nurse List**-----------------------------------");
                                if (per instanceof Nurse) {
                                    ((Nurse) per).print();
                                    System.out.println("\n");
                                }
                            }
                        }
                    } else {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("No Nurse has been registered yet" + "\n");
                    }
                } else {
                    System.out.println("A. Search By ID");
                    System.out.println("B. Search By Name");
                }
                check = true;
                print = true;
                System.out.println("C. Back");
                String choose = inputString.next();
                if (choose.equalsIgnoreCase("A") == true) {
                    System.out.println("Enter the Nurse ID: ");
                    int inputId = inputInt.nextInt();
                    result = serach_by_ID(inputId, true);
                    if (result.size() == 0) {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Your search result was not found!!!!" + "\n");
                        check = false;
                    } else {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Search result for Nurse with " + inputId + " ID: " + "\n");
                        check = false;
                    }

                } else if (choose.equalsIgnoreCase("B") == true) {
                    System.out.println("Enter the Nurse's Name: ");
                    String inputName = inputString2.nextLine();
                    result = Hospital.Search_By_Name(Hospital.getStaff(), inputName);
                    if (result.size() == 0) {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Your search result was not found!!!!" + "\n");
                        check = false;
                    } else {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Search result for Nurse with " + inputName + " ID: " + "\n");
                        check = false;
                    }
                } else if (choose.equalsIgnoreCase("C") == true) {
                    checkPatient = false;
                } else if (choose.equalsIgnoreCase("A") != true && choose.equalsIgnoreCase("B") != true
                        && choose.equalsIgnoreCase("C") != true) {
                    int id = Integer.parseInt(choose);
                    result = serach_by_ID(id, true);
                    if (result.size() == 0) {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("The number is not allowed!!!!!" + "\n");
                        check = false;
                    } else {
                        check = false;
                        print = false;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("The number is not allowed!!!!!" + "\n");
        }

    }

    public void Remove_Clinic_member() {
        Scanner inputString = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println("What is the person's position?(Doctor,Nurse)");
        String position = inputString.nextLine();
        if (position.equalsIgnoreCase("Doctor") == true) {
            System.out.println("Enter the Doctor's ID: ");
            int id = inputInt.nextInt();
            Person human = return_Person(position, id);
            if (human != null) {
                Hospital.fireStaff(id, (Doctor) human);
            } else {
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("There is no Doctor with such an ID!!!!" + "\n");
            }
        } else if (position.equalsIgnoreCase("Nurse") == true) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("Enter the Nurse's ID: ");
            int id = inputInt.nextInt();
            Person human = return_Person(position, id);
            if (human != null) {
                Hospital.fireStaff(id, (Nurse) human);
            } else {
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("There is no Nurse with such an ID!!!!" + "\n");
            }
        }
    }

    public void Add_Clinic_member() {
        Scanner inputString = new Scanner(System.in);
        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println("What is the person's position?(Doctor,Nurse)");
        String position = inputString.nextLine();
        if (position.equalsIgnoreCase("Doctor") == true) {
            System.out.println("Enter the Doctor's Name: ");
            String name = inputString.nextLine();
            System.out.println("Enter the Doctor's phoneNumber:");
            String phon = inputString.nextLine();
            System.out.println("Enter the Doctor's address:");
            String address = inputString.nextLine();
            System.out.println("Enter the Doctor's email:");
            String email = inputString.nextLine();
            System.out.println("Enter the Doctor's Profesion:");
            String Profe = inputString.nextLine();
            System.out.println("Enter the Doctor's password:");
            String password = inputString.nextLine();
            System.out.println("Enter the Doctor's department:");
            String department = inputString.nextLine();
            Hospital.addDoctor(name, phon, address, email, Profe, password, department);
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("Dr." + name + "'s information was successfully registered" + "\n");
        } else if (position.equalsIgnoreCase("Nurse") == true) {
            System.out.println("Enter the Nurse's Name: ");
            String name = inputString.nextLine();
            System.out.println("Enter the Nurse's phoneNumber:");
            String phon = inputString.nextLine();
            System.out.println("Enter the Nurse's address:");
            String address = inputString.nextLine();
            System.out.println("Enter the Nurse's email:");
            String email = inputString.nextLine();
            System.out.println("Enter the Nurse's password:");
            String password = inputString.nextLine();
            System.out.println("Enter the Nurse's department:");
            String department = inputString.nextLine();
            Hospital.addNurse(name, phon, address, email, password, department);
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("Nurse " + name + "'s information was successfully registered" + "\n");
        }
    }

    public void Change_Patient_Description(Doctor doct) {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        Scanner inputInt = new Scanner(System.in);
        System.out.println("Enter the Patient ID:");
        int PatientID = inputInt.nextInt();
        Person patient = Hospital.getPatientByID(PatientID);
        if (patient != null) {
            patient.show_prof();
            Hospital.changePatientDescription(doct, (Patient) patient);
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("Description for a Patient with this " + patient.getID() + " ID was successfully recorded" + "\n");
        } else {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("No Patient with such ID" + "\n");
        }
    }

    public void Visit(Doctor doct) {
        Scanner inputInt = new Scanner(System.in);
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the Patient ID:");
        int PatientID = inputInt.nextInt();
        Person patient = Hospital.getPatientByID(PatientID);
        if (patient != null) {
            patient.show_prof();
            Hospital.examinate((Patient) patient, doct);
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("A patient visit with this " + patient.getID() + " ID was successfully registered" + "\n");
        } else {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("No Patient with such ID" + "\n");
        }
    }

    public List<Person> serach_by_ID(int id, boolean isPatient) {
        List<Person> search = new ArrayList<>();
        if (isPatient == true) {
            List<Person> person = Hospital.getStaff();
            for (Person pers : person) {
                if (pers.getID() == id) {
                    search.add(pers);
                }
            }
        } else if (isPatient == false) {
            List<Person> person2 = Hospital.getPatients();
            for (Person pers : person2) {
                if (pers.getID() == id) {
                    search.add(pers);
                }
            }
        }
        return search;
    }

    public Person return_Person(String human, int id) {
        List<Person> person = Hospital.getStaff();
        for (Person personserch : person) {
            if (personserch.getID() == id && human.equalsIgnoreCase("Doctor") == true && personserch instanceof Doctor) {
                return personserch;
            } else if (personserch.getID() == id && human.equalsIgnoreCase("Nurse") == true && personserch instanceof Nurse) {
                return personserch;
            }
        }
        return null;
    }
}
