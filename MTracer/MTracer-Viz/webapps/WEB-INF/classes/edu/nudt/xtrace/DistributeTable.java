//Standard Normal Distribute Table

package edu.nudt.xtrace;

public class DistributeTable{

//standard normal distribute table, see[3] P439
private static final double[] normalTable={
0.5000,0.5040,0.5080,0.5120,0.5160,0.5199,0.5239,0.5279,0.5319,0.5359,
0.5398,0.5438,0.5478,0.5517,0.5557,0.5596,0.5636,0.5675,0.5714,0.5753,
0.5793,0.5832,0.5871,0.5910,0.5948,0.5987,0.6026,0.6064,0.6103,0.6141,
0.6179,0.6217,0.6255,0.6293,0.6331,0.6368,0.6406,0.6443,0.6480,0.6517,
0.6554,0.6591,0.6628,0.6664,0.6700,0.6736,0.6772,0.6808,0.6844,0.6879,
0.6915,0.6950,0.6985,0.7019,0.7054,0.7088,0.7123,0.7157,0.7190,0.7224,
0.7257,0.7291,0.7324,0.7357,0.7389,0.7422,0.7454,0.7486,0.7517,0.7549,
0.7580,0.7611,0.7642,0.7673,0.7703,0.7734,0.7764,0.7794,0.7823,0.7852,
0.7881,0.7910,0.7939,0.7967,0.7995,0.8023,0.8051,0.8078,0.8106,0.8133,
0.8159,0.8186,0.8212,0.8238,0.8264,0.8289,0.8315,0.8340,0.8365,0.8389,
0.8413,0.8438,0.8461,0.8485,0.8508,0.8531,0.8554,0.8577,0.8599,0.8621,
0.8643,0.8665,0.8686,0.8708,0.8729,0.8749,0.8770,0.8790,0.8810,0.8830,
0.8849,0.8869,0.8888,0.8907,0.8925,0.8944,0.8962,0.8980,0.8997,0.9015,
0.9032,0.9049,0.9066,0.9082,0.9099,0.9115,0.9131,0.9147,0.9162,0.9177,
0.9192,0.9207,0.9222,0.9236,0.9251,0.9265,0.9278,0.9292,0.9306,0.9319,
0.9332,0.9345,0.9357,0.9370,0.9382,0.9394,0.9406,0.9418,0.9430,0.9441,
0.9452,0.9463,0.9474,0.9484,0.9495,0.9505,0.9515,0.9525,0.9535,0.9545,
0.9554,0.9564,0.9573,0.9582,0.9591,0.9599,0.9608,0.9616,0.9625,0.9633,
0.9641,0.9648,0.9656,0.9664,0.9671,0.9678,0.9686,0.9693,0.9700,0.9706,
0.9713,0.9719,0.9726,0.9732,0.9738,0.9744,0.9750,0.9756,0.9762,0.9767,
0.9772,0.9778,0.9783,0.9788,0.9793,0.9798,0.9803,0.9808,0.9812,0.9817,
0.9821,0.9826,0.9830,0.9834,0.9838,0.9842,0.9846,0.9850,0.9854,0.9857,
0.9861,0.9864,0.9868,0.9871,0.9874,0.9878,0.9881,0.9884,0.9887,0.9890,
0.9893,0.9896,0.9898,0.9901,0.9904,0.9906,0.9909,0.9911,0.9913,0.9916,
0.9918,0.9920,0.9922,0.9925,0.9927,0.9929,0.9931,0.9932,0.9934,0.9936,
0.9938,0.9940,0.9941,0.9943,0.9945,0.9946,0.9948,0.9949,0.9951,0.9952,
0.9953,0.9955,0.9956,0.9957,0.9959,0.9960,0.9961,0.9962,0.9963,0.9964,
0.9965,0.9966,0.9967,0.9968,0.9969,0.9970,0.9971,0.9972,0.9973,0.9974,
0.9974,0.9975,0.9976,0.9977,0.9977,0.9978,0.9979,0.9979,0.9980,0.9981,
0.9981,0.9982,0.9982,0.9983,0.9984,0.9984,0.9985,0.9985,0.9986,0.9986,
0.9987,0.9909,0.9993,0.9995,0.9997,0.9998,0.9998,0.9999,0.9999,1.0000
};
//normal distribute
public static double phi(double z)///phi(z), see [3] P439
{
	if(z<=0 || z>1)
		return -1;
	if(z<0.5)
		return -1*phi(1-z);

	for(int i=1;i<normalTable.length;i++){
		if(normalTable[i-1]<=z && z<=normalTable[i]){
			double n1 = 0.1*((int)(i-1)/10)+0.01*((int)(i-1)%10);
			double n2 = n1 + 0.01;
			if(i+1<normalTable.length && normalTable[i] == normalTable[i+1] && z == normalTable[i]){
				return n2+0.005;
			}else{
				return n1+(n2-n1)*(z-normalTable[i-1])/(normalTable[i]-normalTable[i-1]);
			}
		}
	}
	return -1;
}
public static double za(double alpha)//see [3] P61
{
	if(alpha>=0.5 && alpha<=1)
		return -1*phi(alpha);
	if(alpha<0.5 && alpha>0)
		return phi(1-alpha);
	return -1;
		
}

//t distribute table
private static final double[][] TTable={
{1.0000,3.0777,6.3138,12.7062,31.8207,63.6574},
{0.8165,1.8856,2.9200,4.3207,6.9646,9.9248},
{0.7649,1.6377,2.3534,3.1824,4.5407,5.8409},
{0.7407,1.5332,2.1318,2.7764,3.7469,4.6041},
{0.7267,1.4759,2.0150,2.5706,3.3649,4.0322},
{0.7176,1.4398,1.9432,2.4469,3.1427,3.7074},
{0.7111,1.4149,1.8946,2.3646,2.9980,3.4995},
{0.7064,1.3968,1.8595,2.3060,2.8965,3.3554},
{0.7027,1.3830,1.8331,2.2622,2.8214,3.2498},
{0.6998,1.3722,1.8125,2.2281,2.7638,3.1693},
{0.6974,1.3634,1.7959,2.2010,2.7181,3.1058},
{0.6955,1.3562,1.7823,2.1788,2.6810,3.0545},
{0.6938,1.3502,1.7709,2.1604,2.6503,3.0123},
{0.6924,1.3450,1.7613,2.1448,2.6245,2.9768},
{0.6912,1.3406,1.7531,2.1315,2.6025,2.9467},
{0.6901,1.3368,1.7459,2.1199,2.5835,2.9208},
{0.6892,1.3334,1.7396,2.1098,2.5669,2.8982},
{0.6884,1.3304,1.7341,2.1009,2.5524,2.8784},
{0.6876,1.3277,1.7291,2.0930,2.5395,2.8609},
{0.6870,1.3253,1.7247,2.0860,2.5280,2.8453},
{0.6864,1.3232,1.7207,2.0796,2.5177,2.8314},
{0.6858,1.3212,1.7171,2.0739,2.5083,2.8188},
{0.6853,1.3195,1.7139,2.0687,2.4999,2.8073},
{0.6848,1.3178,1.7109,2.0639,2.4922,2.7969},
{0.6844,1.3163,1.7081,2.0595,2.4851,2.7874},
{0.6840,1.3150,1.7056,2.0555,2.4786,2.7787},
{0.6837,1.3137,1.7033,2.0518,2.4727,2.7707},
{0.6834,1.3125,1.7011,2.0484,2.4671,2.7633},
{0.6830,1.3114,1.6991,2.0452,2.4620,2.7564},
{0.6828,1.3104,1.6973,2.0423,2.4573,2.7500},
{0.6825,1.3095,1.6955,2.0395,2.4528,2.7440},
{0.6822,1.3086,1.6939,2.0369,2.4487,2.7385},
{0.0682,1.3077,1.6924,2.0345,2.4448,2.7333},
{0.6818,1.3070,1.6909,2.0322,2.4411,2.7284},
{0.6816,1.3062,1.6896,2.0301,2.4377,2.7238},
{0.6814,1.3055,1.6883,2.0281,2.4345,2.7195},
{0.6812,1.3049,1.6871,2.0262,2.4314,2.7154},
{0.6810,1.3042,1.6860,2.0244,2.4286,2.7116},
{0.6808,1.3036,1.6849,2.0227,2.4258,2.7079},
{0.6807,1.3031,1.6839,2.0211,2.4233,2.7045},
{0.6805,1.3025,1.6829,2.0195,2.4208,2.7012},
{0.6804,1.3020,1.6820,2.0181,2.4185,2.6981},
{0.6802,1.3016,1.6811,2.0167,2.4163,2.6951},
{0.6801,1.3011,1.6802,2.0154,2.4141,2.6923},
{0.6800,1.3006,1.6794,2.0141,2.4121,2.6806}};
//t distribute
public static double t(double alpha, int n)///ta(n), see [3] P441
{
	if(alpha<=0 || alpha>1)
		return -1;
	if(n<1) return -1;
	if(n>45)
		return za(alpha);//see [3] P166
	if(alpha>0.5)
		return -1*t(1-alpha,n);
	int col = -1;
	double delta = 0.00005;
	if(alpha<=0.25+delta && alpha>=0.25-delta) col=0;
	else if(alpha<=0.1+delta && alpha>=0.1-delta) col=1;
	else if(alpha<=0.05+delta && alpha>=0.05-delta) col=2;
	else if(alpha<=0.025+delta && alpha>=0.025-delta) col=3;
	else if(alpha<=0.01+delta && alpha>=0.01-delta) col=4;
	else if(alpha<=0.005+delta && alpha>=0.005-delta) col=5;
	else return -1;
	return TTable[n-1][col];
}

//X2(chi) distribute
private static final double[][] XTable={
{-1,-1,0.001,0.004,0.016,0.102,1.323,2.706,3.841,5.024,6.635,7.879},
{0.01,0.02,0.051,0.103,0.211,0.575,2.773,4.605,5.991,7.378,9.21,10.597},
{0.072,0.115,0.216,0.352,0.584,1.213,4.108,6.251,7.815,9.348,11.345,12.838},
{0.207,0.297,0.484,0.711,1.064,1.923,5.385,7.779,9.488,11.143,13.277,14.86},
{0.412,0.554,0.831,1.145,1.61,2.675,6.626,9.236,11.071,12.833,15.086,16.75},
{0.676,0.872,1.237,1.635,2.204,3.455,7.841,10.645,12.592,14.449,16.812,18.548},
{0.989,1.239,1.69,2.167,2.833,4.255,9.037,12.017,14.067,16.013,18.475,20.278},
{1.344,1.646,2.18,2.733,3.49,5.071,10.219,13.362,15.507,17.535,20.09,21.955},
{1.735,2.088,2.7,3.325,4.168,5.899,11.389,14.684,16.919,19.023,21.666,23.589},
{2.156,2.558,3.247,3.94,4.865,6.737,12.549,15.987,18.307,20.483,23.209,25.188},
{2.603,3.053,3.816,4.575,5.578,7.584,13.701,17.275,19.675,21.92,24.725,26.757},
{3.074,3.571,4.404,5.226,6.304,8.438,14.845,18.549,21.026,23.337,26.217,28.299},
{3.565,4.107,5.009,5.892,7.042,9.299,15.984,19.812,22.362,24.736,27.688,29.819},
{4.075,4.66,5.629,6.571,7.79,10.165,17.117,21.064,23.685,26.119,29.141,31.319},
{4.601,5.229,6.262,7.261,8.547,11.037,18.245,22.307,24.966,27.488,30.578,32.801},
{5.142,5.812,6.908,7.962,9.312,11.912,19.369,23.542,26.296,28.845,32,34.267},
{5.697,6.408,7.564,8.672,10.085,12.792,20.489,24.769,27.587,30.191,33.409,35.718},
{6.265,7.015,8.231,9.39,10.865,13.675,21.605,25.989,28.869,31.526,34.805,37.156},
{6.844,7.633,8.907,10.117,11.651,14.562,22.718,27.204,30.144,32.852,36.191,38.582},
{7.434,8.26,9.591,10.851,12.443,15.452,23.828,28.412,31.41,34.17,37.566,39.997},
{8.034,8.897,10.283,11.591,13.24,16.344,24.935,29.615,32.671,35.479,38.932,41.401},
{8.643,9.542,10.982,12.338,14.042,17.24,26.039,30.813,33.924,36.781,40.289,42.796},
{9.26,10.196,11.689,13.091,14.848,18.137,27.141,32.007,35.172,38.076,41.638,44.181},
{9.886,10.856,12.401,13.848,15.659,19.037,28.241,33.196,36.415,39.364,42.98,45.559},
{10.52,11.524,13.12,14.611,16.473,19.939,29.339,34.382,37.652,40.646,44.314,46.928},
{11.16,12.198,13.844,15.379,17.292,20.843,30.435,35.563,38.885,41.923,45.642,48.29},
{11.808,12.879,14.573,16.151,18.114,21.749,31.528,36.741,40.113,43.194,46.963,49.645},
{12.461,13.565,15.308,16.928,18.939,22.657,32.62,37.916,41.337,44.461,48.278,50.993},
{13.121,14.257,16.047,17.708,19.768,23.567,33.711,39.087,42.557,45.722,49.588,52.336},
{13.787,14.954,16.791,18.493,20.599,24.478,34.8,40.256,43.773,46.979,50.892,53.672},
{14.458,15.655,17.539,19.281,21.434,25.39,35.887,41.422,44.985,48.232,52.191,55.003},
{15.134,16.362,18.291,20.072,22.271,26.304,36.973,42.585,46.194,49.48,53.486,56.328},
{15.815,17.074,19.047,20.867,23.11,27.219,38.058,43.745,47.4,50.725,54.776,57.648},
{16.501,17.789,19.806,21.664,23.952,28.136,39.141,44.903,48.602,51.966,56.061,58.964},
{17.192,18.509,20.569,22.465,24.797,29.054,40.223,46.059,49.802,53.203,57.342,60.275},
{17.887,19.233,21.336,23.269,25.643,29.973,41.304,47.212,50.998,54.437,58.619,61.581},
{18.586,19.96,22.106,24.075,26.492,30.893,42.383,48.363,52.192,55.668,59.892,62.883},
{19.289,20.691,22.878,24.884,27.343,31.815,43.462,49.513,53.384,56.896,61.162,64.181},
{19.996,21.426,23.654,25.695,28.196,32.737,44.539,50.66,54.572,58.12,62.428,65.476},
{20.707,22.164,24.433,26.509,29.051,33.66,45.616,51.805,55.758,59.342,63.691,66.766},
{21.421,22.906,25.215,27.326,29.907,34.585,46.692,52.949,56.942,60.561,64.95,68.053},
{22.138,23.65,25.999,28.144,30.765,35.51,47.766,54.09,58.124,61.777,66.206,69.336},
{22.859,24.398,26.785,28.965,31.625,36.436,48.84,55.23,59.304,62.99,67.459,70.616},
{23.584,25.148,27.575,29.987,32.487,37.363,49.913,56.369,60.481,64.201,68.71,71.893},
{24.311,25.901,28.366,30.612,33.35,38.291,50.985,57.505,61.656,65.41,69.957,73.166}};
//X2(chi) distribute
public static double X2(double alpha, int n)///ta(n), see [3] P441
{
	if(alpha<=0 || alpha>1)
		return -1;
	if(n<1) return -1;
	if(n>45){//see [3] P164
		double tmp=za(alpha)+Math.sqrt(2*n-1);
		return tmp*tmp/2;
	}
	int col = -1;
	double delta = 0.00005;
	if(alpha<=0.995+delta && alpha>=0.995-delta) col=0;
	else if(alpha<=0.99+delta && alpha>=0.99-delta) col=1;
	else if(alpha<=0.975+delta && alpha>=0.975-delta) col=2;
	else if(alpha<=0.95+delta && alpha>=0.95-delta) col=3;
	else if(alpha<=0.9+delta && alpha>=0.9-delta) col=4;
	else if(alpha<=0.75+delta && alpha>=0.75-delta) col=5;
	else if(alpha<=0.25+delta && alpha>=0.25-delta) col=6;
	else if(alpha<=0.1+delta && alpha>=0.1-delta) col=7;
	else if(alpha<=0.05+delta && alpha>=0.05-delta) col=8;
	else if(alpha<=0.025+delta && alpha>=0.025-delta) col=9;
	else if(alpha<=0.01+delta && alpha>=0.01-delta) col=10;
	else if(alpha<=0.005+delta && alpha>=0.005-delta) col=11;
	else return -1;
	return XTable[n-1][col];
}

}























