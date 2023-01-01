import hashlib
import time
import json
import threading
import random

class Block:
    def __init__(self):
        self.chain=[]

    def addNewBlock(self,msg):
        if(self.replay_attack(msg)):
            return
        data={}
        data["time"]=time.time()
        data["id"]=len(self.chain)
        data["message"]=msg
        if len(self.chain)==0:
            data["prevHash"]=0
        else:
            data["prevHash"]=self.chain[-1]["currHash"]
        str=json.dumps(data).encode()
        data["currHash"]=hashlib.sha256(str).hexdigest()
        self.chain.append(data)

    def validate_blocks(self):
        while True:
            ind=-1
            no_blocks=len(self.chain)
            for i in range(1,no_blocks):
                if(self.chain[i]["prevHash"]!=self.chain[i-1]["currHash"]):
                    print("Tampering Found!!")
                    ind=i
                    break
            if ind !=-1:
                for i in range(ind,no_blocks):
                    self.chain[i]["prevHash"]=self.chain[i-1]["currHash"]

    def replay_attack(self,data):
        for block in self.chain:
            if block["message"]==data:
                return True
        return False


def validate():
    validate_thread = threading.Thread(target=block.validate_blocks, name="Validate Blocks")
    validate_thread.start()


if __name__=="__main__":
    block=Block()
    for i in range(5):
        block.addNewBlock("My current count is"+str(i))
    block.chain[2]["currHash"]='1'
    validate()
    
# print(block.chain)
for bk in block.chain:
    print(bk)

           


