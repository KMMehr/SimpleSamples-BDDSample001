package com.bdd.sample.cucumber.stepdef.sample001;

import com.bdd.sample.cucumber.apiinvoke.Sample001ApiInvoke;
import com.bdd.sample.domain.resource.data.Sample001DC;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@CucumberOptions(features = "src/test/java/com/bdd/sample/cucember/feature",
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        glue = {"com.bdd.sample.cucember.config" ,"com.bdd.sample.cucember.stepdef.sample001" })
@AutoConfigureMockMvc
public class Sample001Stepdef {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private Sample001ApiInvoke sample001ApiInvoke;


    @When("^: درخواست_درج_سمپل_بامشخصات_زير_دريافت_مي_شود$")
    public void درخواست_درج_سمپل_بامشخصات_زير_دريافت_مي_شود(DataTable table) {
        Sample001DC.getListFromCucumberTable(table).forEach(sample001Request -> {
            System.out.println("درخواست_درج_سمپل_بامشخصات_زير_دريافت_مي_شود"+" Text: "
                    + sample001Request.getText() + " Age : " + sample001Request.getAge());
            try {
                sample001ApiInvoke.PersistSample001(sample001Request);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    @Then("^: در_لیست_سمپل_هاي_سیستم_فقط_دو_رديف_زير_وجود_دارد$")
    public void در_لیست_سمپل_هاي_سیستم_فقط_دو_رديف_زير_وجود_دارد(DataTable table) {
        Sample001DC.getListFromCucumberTable(table).forEach(sample001Request -> {
            System.out.println( "در_لیست_سمپل_هاي_سیستم_فقط_دو_رديف_زير_وجود_دارد" + "Text: "
                    + sample001Request.getText() + " Age : " + sample001Request.getAge());
            try {
                sample001ApiInvoke.IsExistsSample001Request(sample001Request);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }

    @And("^همه_ي_رديف_هاي_موجود_شناسه_دارند$")
    public void همه_ي_رديف_هاي_موجود_شناسه_دارند() {
        System.out.println("همه_ي_رديف_هاي_موجود_شناسه_دارند");
    }

    @Given(": هيچ_نمونه_اي_از_سمپل_در_پایگاه_داده_وجود_ندارد")
    public void هيچ_نمونه_اي_از_سمپل_در_پایگاه_داده_وجود_ندارد() {
        try {
            sample001ApiInvoke.DeleteAllSample001s();
        }
        catch (Exception exception)        {
            exception.printStackTrace();
        }
    }

    @Given(": هيچ_نمونه_ای_از_رکورد_در پايگاه_داده_وجود_ندارد")
    public void هيچ_نمونه_ای_از_رکورد_درپايگاه_داده_وجود_ندارد() {
        try {
            sample001ApiInvoke.DeleteAllSample001s();
        }
        catch (Exception exception)        {
            exception.printStackTrace();
        }
    }

    @When(": درخواست_درج_رکورد_با_مشخصات_زير_دريافت_مي_شود")
    public void درخواست_درج_رکورد_با_مشخصات_زير_دريافت_مي_شود(DataTable table) {
        Sample001DC.getListFromCucumberTable(table).forEach(sample001Request -> {
            System.out.println("درخواست_درج_سمپل_بامشخصات_زير_دريافت_مي_شود"+" Text: "
                    + sample001Request.getText() + " Age : " + sample001Request.getAge());
            try {
                sample001ApiInvoke.PersistSample001(sample001Request);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    @Then("در_لیست_رکورد_ها_رديف_هاي_زير_وجود_دارد")
    public void در_لیست_رکورد_ها_رديف_هاي_زير_وجود_دارد(DataTable table) {
        Sample001DC.getListFromCucumberTable(table).forEach(sample001Request -> {
            System.out.println( "در_لیست_سمپل_هاي_سیستم_فقط_دو_رديف_زير_وجود_دارد" + "Text: "
                    + sample001Request.getText() + " Age : " + sample001Request.getAge());
            try {
                sample001ApiInvoke.IsExistsSample001Request(sample001Request);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }
}

