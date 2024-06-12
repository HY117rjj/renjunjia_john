function clickRow(row){
	var rowcell = row.all;
	for(i=0;i<rowcell.length;i++){
		var tdcell = rowcell(i);
		if(tdcell.type=='checkbox'||tdcell.type=='radio')
			tdcell.click();
	}
}
function ExtremeTable(id){		
}
