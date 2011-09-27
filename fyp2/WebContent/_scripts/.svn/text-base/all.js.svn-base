var rollOverIndex= new Class({ 
	cellObjects: [], 
	initialCellHeight: null,
	initialize: function(block) {
		this.mainElement= block;
		var cells= this.mainElement.getElements('.indRow');
		this.initialCellHeight= cells[0].getSize().y;
		for (var i= 0; i< cells.length; i++) {
     		var cell= cells[i];
			cell.caption= cell.getElement('.caption');
			cell.abst= cell.caption.getElement('.abst');
			cell.url= cell.abst.getElement('.indURL').get('html');
			cell.changeCell = new Fx.Morph(cell.caption, {duration: 200});
			cell.changeAbst = new Fx.Morph(cell.abst, {duration: 0});
			cell.addEvent("mouseover", this.showCellPreview.pass([cell], this));
			cell.addEvent("mouseleave", this.hideCellPreview.pass([cell], this));
			cell.addEvent("click", this.forwardToURL.pass([cell], this));
			cell.caption.addEvent("click", this.forwardToURL.pass([cell], this));
			this.cellObjects.push(cell);
		}
	},
	forwardToURL: function(activeCell) {
		window.location= activeCell.url;
	},
	showCellPreview: function(activeCell) {
		activeCell.changeCell.stop();
		activeCell.changeCell.start({
			'height': this.initialCellHeight -10,
			'-moz-opacity': '0.8',
			'-khtml-opacity': '0.', 
			'opacity': '0.8'	
		});
		activeCell.changeAbst.stop();
		activeCell.changeAbst.start({'display': 'block'});	
	},
	hideCellPreview: function(activeCell) {
		activeCell.changeCell.stop();
		activeCell.changeCell.start({
			'height': 50,
			'-moz-opacity': '0.7',
			'-khtml-opacity': '0.7', 
			'opacity': '0.7'	
		});
		activeCell.changeAbst.stop();
		activeCell.changeAbst.start({'display': 'none'});	
	}
});

var rollOver= new Class({ 
	cellObjects: [], 
	initialCellHeight: null,
	initialize: function(block) {
		this.mainElement= block;
		var cells= this.mainElement.getElements('.indRow');
		this.initialCellHeight= cells[0].getSize().y;
		for (var i= 0; i< cells.length; i++) {
     		var cell= cells[i];
			cell.caption= cell.getElement('.caption');
			cell.abst= cell.caption.getElement('.abst');
			cell.ol= document.getElementById('overlay' +i);
			cell.changeCell = new Fx.Morph(cell.caption, {duration: 200});
			cell.changeAbst = new Fx.Morph(cell.abst, {duration: 0});
			cell.addEvent("mouseover", this.showCellPreview.pass([cell], this));
			cell.addEvent("mouseleave", this.hideCellPreview.pass([cell], this));
			cell.addEvent("click", this.openOL.pass([cell], this));
			cell.caption.addEvent("click", this.openOL.pass([cell], this));
			this.cellObjects.push(cell);
		}
	},
	openOL: function(activeCell) {
		$(activeCell.ol).overlay({
			mask: {
				color: '#000000',
				loadSpeed: 0,
				opacity: 0.95
			},
			closeOnClick: true,
			load: false,
			top: '15%'
		});
		var ol= $(activeCell.ol).overlay({
			mask: {
				color: '#000000',
				loadSpeed: 0,
				opacity: 0.95
			},
			closeOnClick: true,
			load: false,
			top: '15%'
		});
		ol.load();
	},
	showCellPreview: function(activeCell) {
		activeCell.changeCell.stop();
		activeCell.changeCell.start({
			'height': this.initialCellHeight -10,
			'-moz-opacity': '0.8',
			'-khtml-opacity': '0.', 
			'opacity': '0.8'	
		});
		activeCell.changeAbst.stop();
		activeCell.changeAbst.start({'display': 'block'});	
	},
	hideCellPreview: function(activeCell) {
		activeCell.changeCell.stop();
		activeCell.changeCell.start({
			'height': 50,
			'-moz-opacity': '0.7',
			'-khtml-opacity': '0.7', 
			'opacity': '0.7'	
		});
		activeCell.changeAbst.stop();
		activeCell.changeAbst.start({'display': 'none'});	
	}
});

var resizeWindow= new Class({ 
	initialize: function(type) {
		this.type= type;
		this.resizeFunc();
	},
	resizeFunc: function() {
		if(this.type== 0) {
			var w= $(document.body).getSize().x;
			if(w < 1250) {
        		$$("#wrapper").setStyle('width', "1250px");
     		}  
			else {
    			$$("#wrapper").setStyle('width', w);
    		}
		}
		else if(this.type== 1) {
			var w= document.getElement('body').getSize().x;
			if(w < 1250) {
        		$$("#wrapper").setStyle('width', "1250px");
     		}  
			else {
    			$$("#wrapper").setStyle('width', w);		
    		}
			$$("#subMainContent").setStyle('height', "600px");
			$$("#subMainContent").setStyle('border', "1px solid #c8c8c8");	
			$$("#footer").setStyle('top', "815px");			
		}
		else if(this.type== 2) {
			var w= $(document.body).getSize().x;
			if(w < 1250) {
        		$$("#wrapper").setStyle('width', "1250px");
     		}  
			else {
    			$$("#wrapper").setStyle('width', w);		
    		}
			var h= $(document).getElement('#subMainContent').getScrollSize().y;
			$$("#subMainContent").setStyle('height', h);
			$$("#subMainContent").setStyle('border', "1px solid #c8c8c8");
			$$("#footer").setStyle('top', h + 215);			
		}
		else if(this.type== 3) {
			var w= document.getElement('body').getSize().x;
			if(w < 1250) {
        		$$("#wrapper").setStyle('width', "1250px");
				$$(".overlay").setStyle('width', "900px");
     		}  
			else {
    			$$("#wrapper").setStyle('width', w);
				$$(".overlay").setStyle('width', w * 0.9);
    		}
			$$("#subMainContent").setStyles({
    			height: 600,
    			border: 'none'
			});
			$$("#footer").setStyle('top', "815px");	
			$("ul.tabs").tabs("div.panes > div", {effect: 'ajax'});
		}
		else if(this.type== 4) {
			var w= $(document.body).getSize().x;
			if(w < 1250) {
        		$$("#wrapper").setStyle('width', "1250px");
     		}  
			else {
    			$$("#wrapper").setStyle('width', w);		
    		}
			var h= $(document).getElement('#subMainContent').getScrollSize().y;
			$$("#subMainContent").setStyle('height', h);
			$$("#subMainContent").setStyle('overflow', "visible");
			$$("#subMainContent td").setStyle('height', h);
			$$("#footer").setStyle('top', h + 215);
		}				
	}
});

var accordModule= new Class({ 
	colObjects: [], 
	openCol: null, 
	initialColWidth: null,
	initialLabelHeight: null,
	initialLabelPosition: null,
	mainElement: null,
	isURL: null,
	initialize: function(mainEl, isURL) { 
		this.mainElement= mainEl; 
		this.isURL= isURL;
		var cols= this.mainElement.getElements('.acdCol');
		this.initialColWidth= cols[0].getSize().x;
		$$(".acdLabel").setStyle('width', this.initialColWidth * 0.9);
		this.initialLabelHeight= $$(".acdLabel").getStyle('height')[0].toInt();
		this.initialLabelPosition= $$(".acdLabel").getStyle('bottom')[0].toInt();
		
		for (var i= 0; i< cols.length; i++) {
     		var col= cols[i];
			col.label= col.getElement('.acdLabel');
			col.abst= col.label.getElement('.acdLabelAbs');
			col.changeCol = new Fx.Morph(col, {duration: 400});
			col.changeColLabel = new Fx.Morph(col.label, {duration: 400});
			col.changeColAbst = new Fx.Morph(col.abst, {duration: 400});
			col.addEvent("mouseover", this.showColPreview.pass([col], this));
			col.addEvent("mouseleave", this.hideColPreview.pass([col], this));
			if(this.isURL== 1) {
				col.url= col.abst.getElement('.acdURL').get('html');
				col.label.addEvent("click", this.forwardToURL.pass([col], this));
			}			
			this.colObjects.push(col);
		}
	}, 
	forwardToURL: function(activeCol) {
		window.location= activeCol.url;
	},
	showColPreview: function(activeCol) {
		var obj= {};
		this.previewCol = activeCol;
		for (var i= 0, cols= this.colObjects, len= this.colObjects.length; i< len; i++) {
        	var col= cols[i];
			if(col== activeCol) { 
				col.changeCol.stop();
				col.changeCol.start({'width': this.initialColWidth + 50 * (this.colObjects.length -1)});
				col.changeColLabel.stop();
				col.changeColLabel.start({
					'width': this.initialColWidth * 1.25,
					'height': this.initialLabelHeight * 1.25,
					'bottom': this.initialLabelPosition + 100
				});
				col.changeColAbst.stop();
				col.changeColAbst.start.delay(400, col.changeColAbst, {'display': 'block'});
			}
			else {
				col.changeCol.stop();
				col.changeCol.start({'width': this.initialColWidth - 50});
			}
		}	
	}, 
	hideColPreview: function(col) {
		var obj= {};
		this.previewCol = null;
		for (var i= 0, cols= this.colObjects, len= this.colObjects.length; i< len; i++) {
       		var col= cols[i];
			col.changeCol.stop();
			col.changeCol.start({'width': this.initialColWidth});
			col.changeColLabel.stop();
			col.changeColLabel.start({
				'width': this.initialColWidth * 0.9,
				'height': this.initialLabelHeight,
				'bottom': this.initialLabelPosition
			});
			col.changeColAbst.stop();
			col.changeColAbst.start({'display': 'none'});		
		}
	},
	resizing: function() {
		var windowsWidth= document.getElement('body').getSize().x;
		if (windowsWidth < 1250) {
			windowsWidth = 1250;
     	}
		this.initialColWidth= (windowsWidth * ((1/this.colObjects.length) - 0.027)).toInt();
		$$(".acdLabel").setStyle('width', this.initialColWidth * 0.9);
		
		var obj= {};
		this.previewCol = null;
		for (var i= 0, cols= this.colObjects, len= this.colObjects.length; i< len; i++) {
       		var col= cols[i];
			col.changeCol.stop();
			col.changeCol.start({'width': this.initialColWidth});
		}
	}
}); 