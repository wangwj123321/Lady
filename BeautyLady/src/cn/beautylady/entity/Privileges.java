package cn.beautylady.entity;

/**
 * Created by 王 on 2017/11/26.
 */
public class Privileges {
    private Integer id;
    private String priName;
    private String fnpath;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

    public String getFnpath() {
        return fnpath;
    }

    public void setFnpath(String fnpath) {
        this.fnpath = fnpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
