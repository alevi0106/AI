board=[2]*10
board_copy=[" "]*10


#To draw a board
def draw():
	for i in range(1,10):
		if board[i]==3:
			board_copy[i]="X"
		if board[i]==5:
			board_copy[i]="O"
	#print(board_copy)
	print(' {} | {} | {}'.format(board_copy[1],board_copy[2],board_copy[3]))
	print(' {} | {} | {}'.format(board_copy[4],board_copy[5],board_copy[6]))
	print(' {} | {} | {}'.format(board_copy[7],board_copy[8],board_copy[9]))
	print('')	
	
def Go(n,turn):
	if turn%2==0:
		board[n]=5
	else: board[n]=3 

#To find blank space on board
def fb(a,b,c):
	if board[a]==2:
		return a
	elif board[b]==2:
		return b
	elif board[c]==2:
		return c
	return a

def Make():
	if board[5]==2:
		return 5
	elif board[2]==2:
		return 2
	elif board[4]==2:
		return 4
	elif board[6]==2:
		return 6
	elif board[8]==2:
		return 8
	 
def Posswin(p):
	if p=="X":
		temp=18
	elif p=="O":
		temp=50
	if board[1]*board[2]*board[3]==temp:
		return fb(1,2,3)
	elif board[4]*board[5]*board[6]==temp:
		return fb(4,5,6)
	elif board[7]*board[8]*board[9]==temp:
		return fb(7,8,9)
	elif board[1]*board[5]*board[9]==temp:
		return fb(1,5,9)
	elif board[3]*board[5]*board[7]==temp:
		return fb(3,5,7)
	elif board[1]*board[4]*board[7]==temp:
		return fb(1,4,7)
	elif board[2]*board[5]*board[8]==temp:
		return fb(2,5,8)
	elif board[3]*board[6]*board[9]==temp:
		return fb(3,6,9)	
	return 0

def iswin(turn):
	if(board[1]*board[2]*board[3]==27 or board[4]*board[5]*board[6]==27 or board[7]*board[8]*board[9]==27 or 
		board[1]*board[5]*board[9]==27 or board[3]*board[5]*board[7]==27 or 
		board[1]*board[4]*board[7]==27 or board[2]*board[5]*board[8]==27 or board[3]*board[6]*board[9]==27):
		print("Winner is X")
		return 1
	elif(board[1]*board[2]*board[3]==125 or board[4]*board[5]*board[6]==125 or board[7]*board[8]*board[9]==125 or 
		board[1]*board[5]*board[9]==125 or board[3]*board[5]*board[7]==125 or 
		board[1]*board[4]*board[7]==125 or board[2]*board[5]*board[8]==125 or board[3]*board[6]*board[9]==125):
		print("Winner is O")
		return 1
	elif turn==9:
		print("Match Draw")
		return 1
	return 0

def isdraw(turn):
	posx=posy=0
	for i in range(1,10):
		if board[i]==3:
			if i%2!=0:
				posx+=1
		elif board[i]==5:
			if i%2!=0:
				posy+=1
	#print(posx,posy)
	if(posx==3 and posy==1 and board[5]==3):
		return True
	elif(posx==3 and posy==2 and board[5]==5):
		return True
	else: return False
	return True

val=int(input("Choose 3 for 'X' or 5 for 'O':\n"))
if val==3:
	tempvar1=1
	tempvar2=0
elif val==5:
	tempvar1=0
	tempvar2=1
for turn in range(1,10):
	if turn%2==tempvar1:
		cross=int(input("Where to mark?\n"))
		board[cross]=val
		draw()
		var=iswin(turn)
		if var==1:
			break
	elif turn%2==tempvar2:
		print("AI turn")
		if turn==1:
			Go(1,turn)
			draw()
			var=iswin(turn)
			if var==1:
				break
		if turn==2:
			if board[5]==2:
				Go(5,turn)
			else:
				Go(1,turn)
			draw()
			var=iswin(turn)
			if var==1:
				break
		if turn==3:
			if board[9]==2:
				Go(9,turn)
			else:
				Go(3,turn)
			draw()
			var=iswin(turn)
			if var==1:
				break
		if turn==4:
			if Posswin("X")!=0:
				Go(Posswin("X"),turn)
			else: Go(Make(),turn)
			draw()
			var=iswin(turn)
			if var==1:
				break
		if turn==5:
			if Posswin("X")!=0:
				Go(Posswin("X"),turn)
			elif Posswin("O")!=0:
				Go(Posswin("O"),turn)
			elif board[7]==2:
				Go(7,turn)
			else: Go(3,turn)
			draw()
			var=iswin(turn)
			if var==1:
				break
		if turn==6:
			if Posswin("O")!=0:
				Go(Posswin("O"),turn)
			elif Posswin("X")!=0:
				Go(Posswin("X"),turn)
			else: Go(Make(),turn)
			draw()
			var=iswin(turn)
			if var==1:
				break
		if turn==7 or turn==9:
			if Posswin("X")!=0:
				Go(Posswin("X"),turn)
			elif Posswin("O")!=0:
				Go(Posswin("O"),turn)
			else: Go(fb(fb(1,2,3),fb(4,5,6),fb(7,8,9)),turn)
			draw()
			var=iswin(turn)
			if var==1:
				break
		if turn==8:
			if Posswin("O")!=0:
				Go(Posswin("O"),turn)
			elif Posswin("X")!=0:
				Go(Posswin("X"),turn)
			else: Go(fb(fb(1,2,3),fb(4,5,6),fb(7,8,9)),turn)
			draw()
			var=iswin(turn)
			if var==1:
				break
	if turn==5:
		if isdraw(turn)==False:
			print("Match will be draw")
			break



