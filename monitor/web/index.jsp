<html>
<head>
    <LINK REL=StyleSheet HREF="css/layout.css" TYPE="text/css">

    <script language="javascript" type="text/javascript" src="js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>
    <script language="javascript" type="text/javascript" src="js/excanvas.js"></script>
    <script language="javascript" type="text/javascript" src="js/approximation.js"></script>

    <script id="source" language="javascript" type="text/javascript">
        var refresh;
        var clus1memtime;
        var clus1cputime;
        var clus2memtime;
        var clus2cputime;
        var clus3memtime;
        var clus3cputime;
        var clus4memtime;
        var clus4cputime;

        var running = false;

        function GenericGraph(xscale, type) {
            this.array = new Array();
            if (type == "mem") {
                this.color = "0, 76, 191";
                this.label = "Memory Usage";
            } else {
                this.color = "0, 191, 76";
                this.label = "CPU Usage";
            }
            for (var i = 0; i < xscale; i++) {
                this.array[i] = [i, 0.0];
            }
            this.xscale = xscale;
        }

        function getValues() {
            return this.array;
        }

        function addValue(val) {
            var arr = new Array();
            //shift to left
            for (var i = 0; i < this.xscale - 1; i++) {
                this.array[i] = [i,this.array[i + 1][1]];  // (x,y)
            }

            //add the value to the last postion
            this.array[this.xscale - 1] = [this.xscale - 1,val];
        }

        function draw(id) {
                $.plot($(id), [
                    {
                        label: this.label + ((this.array[this.xscale - 1])[1]).toFixed(2) + " (MB)",
                        data: this.getValues(),
                        lines: { show: true, fill: true, fillColor: "rgba("+this.color+",0.3)",lineWidth: 3.5 },
                        color:"rgba("+this.color+",1)",
                        hoverable: true
                    }
                ],
                {
                    xaxis: {
                        ticks: clus1memtime.generateTicks(),
                        min: 0

                    },
                    yaxis: {
//                        ticks: clus1memtime.generateYTicks(),
                        max: 1.2,
//                        ticks: [0 , 0.2, 0.4, 0.6, 0.8, 0.9, 1.0, 1.1, 1.2],
                        tickSize: [0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2], 
                        min: 0
                    },
                    grid: {
                        show: true,
                        color: '#474747',
                        tickColor: '#474747',
                        borderWidth: 1,
                        autoHighlight: true,
                        mouseActiveRadius: 2
                      }


                });
        }

        GenericGraph.prototype.addValue = addValue;
        GenericGraph.prototype.getValues = getValues;
        GenericGraph.prototype.generateTicks = generateTicks;
        GenericGraph.prototype.draw = draw;



        function initialize() {
            clus1memtime = new GenericGraph(100, "mem");
            clus1cputime = new GenericGraph(100, "cpu");
            clus2memtime = new GenericGraph(100, "mem");
            clus2cputime = new GenericGraph(100, "cpu");
            clus3memtime = new GenericGraph(100, "mem");
            clus3cputime = new GenericGraph(100, "cpu");
            clus4memtime = new GenericGraph(100, "mem");
            clus4cputime = new GenericGraph(100, "cpu");
        }

        function generateTicks() {
            var tickArray = [];
            var startTick = 20;
            var i = startTick - 1;
            var weight = this.xscale / 20;
            do {
                var t = (startTick - i) * weight - 1;
                var v = i * weight;
                if (v == 0) {
                    v = "0";
                }
                tickArray.push([t, v]);
                i--;
            } while (i > -1);
            return tickArray;
        }

        function refreshStat() {
            var url = "stat.jsp";
            $("#main").load(url);
        }

        $(document).ready(function () {
            initialize();
            refreshStat();
            refresh = setInterval("refreshStat()", 500);
        });

    </script>
</head>
<body>
    <div id="main" >

    </div>
</body>
</html>