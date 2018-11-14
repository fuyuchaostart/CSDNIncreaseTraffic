package csdnandcnblogs;

/**
 * 功能描述:
 *
 * @author fuyuchao
 * DATE 2018/8/29.
 */
public class AgencyIp {
    private String address;
    private String port;

    public AgencyIp() {
    }

    public AgencyIp(String address, String port) {
        this.address = address;
        this.port = port;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
