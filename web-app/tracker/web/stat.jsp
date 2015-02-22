<%@ page import="client.WSClient" %>
<%@ page import="salsa.services.xsd.ClusStat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    WSClient client = new WSClient();
    ClusStat [] stats = client.getStat();
    String memUsage = "";
    String cpuUsage = "";
    String tr = "";
    int i = 0;
    for (ClusStat stat : stats) {
//        tr += generateTitleTr(i, stat.getName());
        tr += generateGraphTr(i);
        if (i < stats.length - 1) {
            memUsage += stat.getMemUsage() + ",";
            cpuUsage += stat.getCpuUsage() + ",";
        } else {
            memUsage += stat.getMemUsage();
            cpuUsage += stat.getCpuUsage();
        }
        i++;
    }
%>
<%!
    String generateGraphTr(int index) {
        return "<tr>" +
                "<td>" +
                "<div id=\"cpuGraph" + index + "\" class=\"graph\"></div>" +
                "</td>" +
                "<td>" +
                "<div id=\"memGraph" + index + "\" class=\"graph\"></div>" +
                "</td>" +
                "</tr>";
    }
%>

<%!
    String generateTitleTr(int index, String clusName) {
        return "<tr>" +
                "<td>" +
                "<div id=\"cpuTitle" + index + "\" class=\"title\">Cluster " + (index + 1) + ": " + clusName + "<br>" + "CPU Usage Vs Time</div>" +
                "</td>" +
                "<td>" +
                "<div id=\"memTitle" + index + "\" class=\"title\">Cluster " + (index + 1) + ": " + clusName + "<br>" + "Memory Usage Vs Time</div>" +
                "</td>" +
                "</tr>";
    }
%>
<table cellspacing="50">
        <%=tr%>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<div id="cpuGraph0" class="graph"></div>--%>
        <%--</td>--%>
    <%--</tr>--%>

        <script type="text/javascript">
            var memUsage = new Array(<%=memUsage%>);
            var cpuUsage = new Array(<%=cpuUsage%>);
//            var cpuUsage = new Array(100,200,300,400,500);
//            alert(memUsage);

//            alert(cpuUsage[0]);
            for (var i = 0; i < 4; i++) { // both memUsage and cpuUsage have the same length
//                alert(cpuUsage[i])
                cpuGraphs[i].addValue(cpuUsage[i]);
                memGraphs[i].addValue(memUsage[i]);
//                memGraphs[i].draw("#memGraph" + i);
//                cpuGraphs[i].draw("#cpuGraph" + i);
            }


//            g.addValue(Math.random());
//            g.draw("#cpuGraph0");
        </script>
</table>