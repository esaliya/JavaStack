<html>
<head>
    <LINK REL=StyleSheet HREF="css/layout.css" TYPE="text/css">

    <script language="javascript" type="text/javascript" src="js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>
    <script language="javascript" type="text/javascript" src="js/excanvas.js"></script>
    <script language="javascript" type="text/javascript" src="js/approximation.js"></script>

    <script id="source" language="javascript" type="text/javascript">
        var numOfClusters;
        var memGraphs;
        var cpuGraphs;
        var g;

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
                        label: this.label + ((this.array[this.xscale - 1])[1]).toFixed(2),
                        data: this.getValues(),
                        lines: { show: true, fill: true, fillColor: "rgba("+this.color+",0.3)",lineWidth: 3.5 },
                        color:"rgba("+this.color+",1)",
                        hoverable: true
                    }
                ],
                {
                    xaxis: {
                        ticks: this.generateTicks(),
                        min: 0

                    },
                    yaxis: {
                        ticks: this.generateYTicks(),
                        tickSize:[10, 10,10,10,10,5,5,5,5,5,5,5,5,5,5],
//
//                                axis.tickSize = 5;
//                            else
//                                axis.tickSize = 1;
//                        }),
//                        tickFormatter:(function formatter(val, axis) {
//                            if (val < 30)
//                                axis.tickSize = 5;
//                            else
//                                axis.tickSize = 1;
//                        }),

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
        GenericGraph.prototype.generateYTicks = generateYTicks;


        function initialize() {
            numOfClusters = 4;
            memGraphs = new Array();
            cpuGraphs = new Array();
            g = new GenericGraph(100, 'cpu');

            for (var i = 0; i < numOfClusters; i++) {
                memGraphs[i] = new GenericGraph(100, "mem");
                cpuGraphs[i] = new GenericGraph(100, "cpu");
            }
        }

        function generateTicks() {
            var tickArray = [];
            var startTick = 10;
            var i = startTick - 1;
            var weight = this.xscale / 10;
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

        function generateYTicks() {
            var tickArry = [];
            var i = 0;
            for (i; i<50 ;i=i+10) {
                tickArry.push(i);
            }
            for (i = 50; i<100; i++) {
                tickArry.push(i);
            }
            return tickArry;
        }

        function refreshStat() {
            var url = "stat.jsp";
            $("#main").load(url, null, function (responseText, textStatus, XMLHttpRequest) {
                if (textStatus == 'success') {
                    memGraphs[0].draw("#memGraph0");
                    cpuGraphs[0].draw("#cpuGraph0");
                    memGraphs[1].draw("#memGraph1");
                    cpuGraphs[1].draw("#cpuGraph1");
                    memGraphs[2].draw("#memGraph2");
                    cpuGraphs[2].draw("#cpuGraph2");
                    memGraphs[3].draw("#memGraph3");
                    cpuGraphs[3].draw("#cpuGraph3");
//                    memGraphs[4].draw("#memGraph4");
//                    cpuGraphs[4].draw("#cpuGraph4");
                }
            }
                    );
        }

        $(document).ready(function () {
            initialize();
            refreshStat();
            setInterval("refreshStat()", 500);
        });

    </script>
</head>
<body>
    <div id="main" >
    
    </div>
</body>
</html>