package demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;


public class Driver {
    public static void main(String[] args) {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            Student myStudent = mapper.readValue(new File("data/sample-full.json"),Student.class);

            System.out.println("First name= "+ myStudent.getFirstName());
            System.out.println("Last Name= "+ myStudent.getLastName());

            Address tempAddress = myStudent.getAddress();

            System.out.println("Street = "+ tempAddress.getStreet());
            System.out.println("city = "+ tempAddress.getCity());

            for(String tempLang:myStudent.getLanguages()){
                System.out.println(tempLang);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
