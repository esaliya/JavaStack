<%--<%@ page import="client.WSClient" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%
//    long val = Math.round(Math.random() * 10);
//    double clus1memtime = ((double)val) /10;
//    WSClient client = new WSClient();

//    double clus1memtime = client.getStat();
//    double clus1cputime = client.getStat();
    double clus1memtime = Math.random();
    double clus1cputime = Math.random();

%>
<table cellspacing="50">
        <tr>
            <td>
            <div id="placeholder" class="graph"></div>
            </td>
            <td>
            <div id="placeholder2" class="graph"></div>
            </td>
        </tr>
        <tr>
            <td>
            <div id="placeholder3" class="graph"></div>
            </td>
            <td>
            <div id="placeholder4" class="graph"></div>
            </td>
        </tr>
        <tr>
            <td>
            <div id="placeholder5" class="graph"></div>
            </td>
            <td>
            <div id="placeholder6" class="graph"></div>
            </td>
        </tr>
        <tr>
            <td>
            <div id="placeholder7" class="graph"></div>
            </td>
            <td>
            <div id="placeholder8" class="graph"></div>
            </td>
        </tr>

        <script type="text/javascript">
            if (!running) {
                running = true;
                clus1memtime.addValue(Math.random());
                clus1cputime.addValue(Math.random());
                clus2memtime.addValue(Math.random());
                clus2cputime.addValue(Math.random());
                clus3memtime.addValue(Math.random());
                clus3cputime.addValue(Math.random());
                clus4memtime.addValue(Math.random());
                clus4cputime.addValue(Math.random());

                clus1memtime.draw("#placeholder");
                clus1cputime.draw("#placeholder2");
                clus2memtime.draw("#placeholder3");
                clus2cputime.draw("#placeholder4");
                clus3memtime.draw("#placeholder5");
                clus3cputime.draw("#placeholder6");
                clus4memtime.draw("#placeholder7");
                clus4cputime.draw("#placeholder8");
                running = false;
            }
        </script>
    </table>