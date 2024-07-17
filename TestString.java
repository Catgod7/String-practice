public String getString(String str){
String getNumber;
getNumber = str.replaceAll(¡°[a-z|A-Z]¡°, ¡±");
if(getNumber.indexOf(¡°.¡±) == -1){
getNumber = getNumber+¡±.00¡å;
} else {
if(getNumber.indexOf(¡°.¡±)== getNumber.length()-1){
getNumber = getNumber+¡±00¡å;
} else if (getNumber.indexOf(¡°.¡±)== getNumber.length()-2){
getNumber = getNumber+¡±0¡å;
} else {
getNumber = getNumber.substring(0, getNumber.indexOf(¡°.¡±)+3);
}
}
return getNumber;
}