package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TpTable {

    private String email;
    private String password;
    private String cid;
    private String companyName;
    private String ArcNumber;
    private String travelAgency;
    private String accountType;
    private String name;
    private String contactNameList;
    private String contactEmail;
    private String contactPhone;
    private String contactRole;
    private String secondaryAccount;
}
