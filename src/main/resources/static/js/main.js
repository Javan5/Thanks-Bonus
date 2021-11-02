function getIndex(list, id) {
	for( var i = 0; i <list.length; i++) {
		if (list[i].id === id) {
			return i;
		}
	}
	return -1;
}
var bankApi = Vue.resource('/bankInfo{/id}');

Vue.component('bank-form', {
	props: ['banks', 'bankAttr'],
	data: function() {
		return {
			text: '',
			id: ''
		}
	},
	watch: {
		bankAttr: function(newVal, oldVal){
			this.text = newVal.text;
			this.id = newVal.id;
		}
	},
	template:
		'<div>'+
			'<input type="text" placeholder="Write banks" v-model = "text"/>'+
			'<input type="button" value="Save" @click="save" />'+
			'</div>',
	methods: {
		save: function() {
				var bankInfo = { text: this.text };
				if (this.id) {
					bankApi.update({id: this.id}, bankInfo).then( result =>
					result.json().then( data => {
						var index = getIndex(this.banks, data.id);
						this.banks.splice(index, 1, data);
						this.text = ''
						this.id = ''
					})
					)
				} else {
						bankApi.save({}, bankInfo).then(result =>
								result.json().then(data => {
									this.banks.push(data)
								})
						)
				}
		}
	}
});

Vue.component('bank-row',{
	props: ['bankInfo', 'editMethod', 'banks'],
	template: '<div>' +
			'<i>({{ bankInfo.id}}) </i> {{bankInfo.text }} ' +
			'<span style="position: absolute; right: 0">'+
			'<input type="button" value="Edit" @click="edit"/>'+
			'<input type="button" value="X" @click="del"/>'+
			'</span>'+
			'</div>',
	methods: {
		edit: function() {
			this.editMethod(this.bankInfo);
		},
		del: function() {
				bankApi.remove({id: this.bankInfo.id}).then(result =>{
					if (result.ok) {
						this.banks.splice(this.banks.indexOf(this.bankInfo), 1)
					}
				})
		}
	}
});

Vue.component('banks-list', {
	props: ['banks'],
	data: function() {
		return {
			bankInfo: null
		}
	},
	template:
			'<div style ="position: relative:width: 300px;">' +
			'<bank-form :banks="banks" :bankAttr="bankInfo"/>'+
			'<bank-row v-for="bankInfo in banks" :key="bankInfo.id" :bankInfo="bankInfo" ' +
			':editMethod="editMethod" :banks="banks" />' +
			'</div>',
	created: function() {
		bankApi.get().then(result =>
			result.json().then(data =>
					data.forEach(bankInfo => this.banks.push(bankInfo))
			)
		)
	},
	methods: {
		editMethod: function(bankInfo) {
			this.bankInfo = bankInfo;
		}
	}
});

var app = new Vue ({
	el: '#app',
	template: '<banks-list :banks="banks"/>',
	data: {
		banks: []
	}
});