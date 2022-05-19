package testSuite.TestCases;

import GenericFunctions.WaitGeneric;
import dto.LoadDataFromDB;
import entity.TpTable;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.util.List;


public class InitializeValues extends GenericActions{
    protected String username = null;
    protected String password = null;
    protected String userUsername = null;
    protected String userPassword = null;
    protected String accountSearch = null;
    protected String companyName = null;
    protected String ArcNumber = null;
    protected String travelAgency = null;
    protected String accountType = null;
    protected String name = null;
    protected String[] contact = null;
    protected String secondaryAccount = null;
    protected String contactEmail;
    protected String contactPhone;
    protected String contactRole;

    public void _initValues(String email) {
        List<TpTable> load = null;
        LoadDataFromDB data = null;
        try {
            data = new LoadDataFromDB();
            load = data.load(email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (load != null) {
            userUsername = load.get(0).getEmail();
            userPassword = load.get(0).getPassword();
            accountSearch = load.get(0).getCid();
            companyName = load.get(0).getCompanyName();
            ArcNumber = load.get(0).getArcNumber();
            travelAgency = load.get(0).getTravelAgency();
            accountType = load.get(0).getAccountType();
            name = load.get(0).getName();
            contact = setValuesAsArray(load.get(0).getContactNameList());
            contactEmail = load.get(0).getContactEmail();
            contactPhone = load.get(0).getContactPhone();
            contactRole = load.get(0).getContactRole();
            secondaryAccount = load.get(0).getSecondaryAccount();
        }
        setSystemValues(data);
    }

    public void setSystemValues()
    {
        LoadDataFromDB data = null;
        try{
            data = new LoadDataFromDB();
        }
        catch(Exception e)
        {

        }
        setSystemValues(data);
    }

    public void setSystemValues(LoadDataFromDB data) {
        List<TpTable> load = data.load("automation.test@wnco.com");
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        System.setProperty("username",load.get(0).getEmail());
        System.setProperty("password",load.get(0).getPassword());

        username = System.getProperty("username");
        password = System.getProperty("password");
        System.out.println(username+"------");
    }

    public String[]  setValuesAsArray(String list) {
        String[] arrayList = list.split("\\|");
        return arrayList;
    }

    public WaitGeneric testSessionInitiator(Actor actor)
    {
        WaitGeneric wait = new WaitGeneric(actor);
        return wait;
    }


}
