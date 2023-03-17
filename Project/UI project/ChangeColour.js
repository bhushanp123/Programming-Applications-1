function changeBgColor(rowID, color) 
{
    

    if(rowID==0){
        var x=document.getElementsByTagName("tr");
        var c=x.length;
        for(let i=0;i<x.length;i++){
            if(i%2!=0)
            {

                x[i].style.backgroundColor='white';
            }
            else{
                x[i].style.backgroundColor=color;
            }
            
        }
    }
    else{
        var row = document.getElementById(rowID);
        row.style.backgroundColor = color;
    }
}