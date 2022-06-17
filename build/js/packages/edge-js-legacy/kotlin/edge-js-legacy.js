(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'edge-js-legacy'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'edge-js-legacy'.");
    }root['edge-js-legacy'] = factory(typeof this['edge-js-legacy'] === 'undefined' ? {} : this['edge-js-legacy'], kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  Some.prototype = Object.create(Option.prototype);
  Some.prototype.constructor = Some;
  function Option() {
  }
  Option.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Option',
    interfaces: []
  };
  function Some(value) {
    Option.call(this);
    this.value = value;
  }
  Some.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Some',
    interfaces: [Option]
  };
  Some.prototype.component1 = function () {
    return this.value;
  };
  Some.prototype.copy_11rb$ = function (value) {
    return new Some(value === void 0 ? this.value : value);
  };
  Some.prototype.toString = function () {
    return 'Some(value=' + Kotlin.toString(this.value) + ')';
  };
  Some.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.value) | 0;
    return result;
  };
  Some.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.value, other.value))));
  };
  function createSome(value) {
    return new Some(value);
  }
  var package$effects = _.effects || (_.effects = {});
  package$effects.Option = Option;
  package$effects.Some = Some;
  package$effects.createSome_mh5how$ = createSome;
  Kotlin.defineModule('edge-js-legacy', _);
  return _;
}));

//# sourceMappingURL=edge-js-legacy.js.map
