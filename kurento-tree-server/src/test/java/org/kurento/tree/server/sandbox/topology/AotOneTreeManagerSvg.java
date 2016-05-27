/*
 * (C) Copyright 2016 Kurento (http://kurento.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.kurento.tree.server.sandbox.topology;

import org.kurento.tree.server.debug.KmsTopologyGrapher;
import org.kurento.tree.server.kmsmanager.FakeFixedNKmsManager;
import org.kurento.tree.server.kmsmanager.KmsManager;
import org.kurento.tree.server.treemanager.LexicalFixedTM;

public class AotOneTreeManagerSvg {

  public static void main(String[] args) {

    KmsManager kmsManager = new FakeFixedNKmsManager(4);
    LexicalFixedTM aot = new LexicalFixedTM(kmsManager);

    System.out.println(KmsTopologyGrapher.createSvgTopologyGrapher(kmsManager));

    String treeId = aot.createTree();
    aot.setTreeSource(null, treeId, "XXX");

    System.out.println(KmsTopologyGrapher.createSvgTopologyGrapher(kmsManager));

    aot.addTreeSink(null, treeId, "JJJ");
    aot.addTreeSink(null, treeId, "FFF");

    System.out.println(KmsTopologyGrapher.createSvgTopologyGrapher(kmsManager));
  }
}
