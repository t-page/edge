(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'edge-js-legacy', 'kotlin-test'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('edge-js-legacy'), require('kotlin-test'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'edge-js-legacy-test'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'edge-js-legacy-test'.");
    }if (typeof this['edge-js-legacy'] === 'undefined') {
      throw new Error("Error loading module 'edge-js-legacy-test'. Its dependency 'edge-js-legacy' was not found. Please, check whether 'edge-js-legacy' is loaded prior to 'edge-js-legacy-test'.");
    }if (typeof this['kotlin-test'] === 'undefined') {
      throw new Error("Error loading module 'edge-js-legacy-test'. Its dependency 'kotlin-test' was not found. Please, check whether 'kotlin-test' is loaded prior to 'edge-js-legacy-test'.");
    }root['edge-js-legacy-test'] = factory(typeof this['edge-js-legacy-test'] === 'undefined' ? {} : this['edge-js-legacy-test'], kotlin, this['edge-js-legacy'], this['kotlin-test']);
  }
}(this, function (_, Kotlin, $module$edge_js_legacy, $module$kotlin_test) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var createSome = $module$edge_js_legacy.effects.createSome_mh5how$;
  var Some = $module$edge_js_legacy.effects.Some;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var test = $module$kotlin_test.kotlin.test.test;
  var suite = $module$kotlin_test.kotlin.test.suite;
  var assertTrue = $module$kotlin_test.kotlin.test.assertTrue_ifx8ge$;
  function OptionTest() {
  }
  OptionTest.prototype.testCreateSome = function () {
    var expectedSome = createSome('I am a Some');
    assertTrue(Kotlin.isType(expectedSome, Some), null);
  };
  OptionTest.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'OptionTest',
    interfaces: []
  };
  $$importsForInline$$['kotlin-test'] = $module$kotlin_test;
  var package$effects = _.effects || (_.effects = {});
  package$effects.OptionTest = OptionTest;
  suite('effects', false, function () {
    suite('OptionTest', false, function () {
      test('testCreateSome', false, function () {
        return (new OptionTest()).testCreateSome();
      });
    });
  });
  Kotlin.defineModule('edge-js-legacy-test', _);
  return _;
}));

//# sourceMappingURL=edge-js-legacy-test.js.map
